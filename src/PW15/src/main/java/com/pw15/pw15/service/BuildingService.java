package com.pw15.pw15.service;

import com.pw15.pw15.model.Building;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class BuildingService {
    private final SessionFactory sessionFactory;
    private Session session;

    public BuildingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Building> getAllBuildings() {
        session = sessionFactory.openSession();
        List<Building> buildings = session.createQuery("from Building").getResultList();
        session.close();
        return buildings;
    }

    public void addEntity(Building building) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(building);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteEntity(Building building) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("DELETE FROM Building WHERE " +
                "creationDate = :creationdate AND type = :type");
        q.setParameter("creationdate", building.getCreationDate())
                .setParameter("type", building.getType())
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
