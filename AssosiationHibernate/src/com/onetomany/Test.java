package com.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Test {

	public static void main(String[] args) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			System.out.println("excepton occurred " + e.getMessage());
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Person person=new Person();
		Phones phones=new Phones("8985894205");
		Phones phone1=new Phones("8612365468");
		Person person1=new Person();
		
		person.getPhones().add(phone1);
		person.getPhones().add(phones);
		person1.getPhones().add(phone1);
		person1.getPhones().add(phones);
		session.save(person);
		session.save(phone1);
		session.save(phones);
	
		
		session.getTransaction().commit();
		session.close();
	}

}
