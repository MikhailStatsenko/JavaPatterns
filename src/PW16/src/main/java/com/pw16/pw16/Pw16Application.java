package com.pw16.pw16;

import com.pw16.pw16.configuration.SQLConfig;
import com.pw16.pw16.model.Address;
import com.pw16.pw16.model.Building;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;


public class Pw16Application {
	public static void main(String[] args) throws IOException {
		SessionFactory sessionFactory = new SQLConfig().sessionFactory();

//		Address address1 = new Address(
//				"1234 Pine Street Los Angeles,United States",
//				"90001");
//		Address address2 = new Address(
//				"14 Voulis Street, Greece",
//				"105 57");
//
//		Building building1 = new Building("25.12.1997", "Office building");
//		Building building2 = new Building("11.01.2002", "Hotel");
//		Building building3 = new Building("13.02.2012", "Shopping mall");
//		Building building4 = new Building("31.08.2009", "Residential house");
//
//		address1.addBuildingToAddress(building1);
//		address1.addBuildingToAddress(building2);
//
//		address2.addBuildingToAddress(building3);
//		address2.addBuildingToAddress(building4);
//
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//
//		session.persist(address1);
//		session.persist(address2);
//
//		session.getTransaction().commit();


// ******************************************************

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("\nGet address\n");
		Address address = session.get(Address.class, 51L);

		System.out.println("\nPrint address info");
		System.out.println("\n" + address + "\n");

//		System.out.println("\nShow buildings");
//		System.out.println("\n" + address.getBuildings() + "\n");

		System.out.println("\nCommit\n");

		session.getTransaction().commit();
		session.close();

		System.out.println("\nShow buildings");
		System.out.println("\n" + address.getBuildings() + "\n");


		sessionFactory.close();
	}
}
