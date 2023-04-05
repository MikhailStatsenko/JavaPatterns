package com.pw17.pw17.service;

import com.pw17.pw17.model.Address;
import com.pw17.pw17.model.Building;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Service
public class BuildingService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    private void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    private void finish() {
        session.close();
        sessionFactory.close();
    }
    public BuildingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Building> getAllBuildings() {
        return (List<Building>) session.createQuery("from Building").getResultList();
    }

    public void addEntity(Building building, long address_id) {
        session.beginTransaction();
        Address addressFromDb = session.get(Address.class, address_id);
        addressFromDb.addBuildingToAddress(building);
        session.persist(building);
        session.getTransaction().commit();
    }

    public void deleteEntity(Building building) {
        session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Building WHERE " +
                "creationDate = :creationdate AND type = :type");
        q.setParameter("creationdate", building.getCreationDate())
                .setParameter("type", building.getType())
                .executeUpdate();
        session.getTransaction().commit();
    }

    public List<Building> sortBuildingsOrderedByCreationDate() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Building> buildingCriteriaQuery = builder.createQuery(Building.class);
        Root<Building> root = buildingCriteriaQuery.from(Building.class);

        buildingCriteriaQuery.select(root).orderBy(builder.asc(builder.function(
                "to_date", Date.class, root.get("creationDate"), builder.literal("DD.MM.YYYY"))));
        org.hibernate.query.Query<Building> query = session.createQuery(buildingCriteriaQuery);
        return query.getResultList();
    }

    public List<Building> filterBuildingsByType(String type) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Building> buildingCriteriaQuery = builder.createQuery(Building.class);
        Root<Building> root = buildingCriteriaQuery.from(Building.class);

        buildingCriteriaQuery.select(root).where(builder.equal(root.get("type"), type));
        org.hibernate.query.Query<Building> query = session.createQuery(buildingCriteriaQuery);
        return query.getResultList();
    }
}
