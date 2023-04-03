package com.pw15.pw15.service;

import com.pw15.pw15.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class AddressService {
    private final SessionFactory sessionFactory;
    private Session session;

    public AddressService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Address> getAllAddresses() {
        session = sessionFactory.openSession();
        List<Address> addresses = session.createQuery("from Address").getResultList();
        session.close();
        return addresses;
    }

    public void addEntity(Address address) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(address);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteEntity(Address address) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query q =  session.createQuery("DELETE FROM Address WHERE " +
                "addressText = :addresstext AND zipCode = :zipcode");
        q.setParameter("addresstext", address.getAddressText())
                .setParameter("zipcode", address.getZipCode())
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
