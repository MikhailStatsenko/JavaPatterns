package com.pw17.pw17.service;

import com.pw17.pw17.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class AddressService {
    private final SessionFactory sessionFactory;
    private Session session;

    public AddressService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    private void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    private void finish() {
        session.close();
        sessionFactory.close();
    }

    public List<Address> getAllAddresses() {
        return (List<Address>) session.createQuery("from Address").getResultList();
    }

    public void addEntity(Address address) {
        session.beginTransaction();
        session.persist(address);
        session.getTransaction().commit();
    }

    public void deleteEntity(Address address) {
        session.beginTransaction();
        Query q =  session.createQuery("DELETE FROM Address WHERE " +
                "addressText = :addresstext AND zipCode = :zipcode");
        q.setParameter("addresstext", address.getAddressText())
                .setParameter("zipcode", address.getZipCode())
                .executeUpdate();
        session.getTransaction().commit();
    }

    public List<Address> sortAddressesOrderedByZipCode() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> addressCriteriaQuery = builder.createQuery(Address.class);
        Root<Address> root = addressCriteriaQuery.from(Address.class);

        addressCriteriaQuery.select(root).orderBy(builder.asc(root.get("zipCode")));
        Query<Address> query = session.createQuery(addressCriteriaQuery);
        return query.getResultList();
    }

    public List<Address> filterAddressesByAddressText(String addressText) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> addressCriteriaQuery = builder.createQuery(Address.class);
        Root<Address> root = addressCriteriaQuery.from(Address.class);

        addressCriteriaQuery.select(root).where(builder.equal(root.get("addressText"), addressText));
        Query<Address> query = session.createQuery(addressCriteriaQuery);
        return query.getResultList();
    }

}
