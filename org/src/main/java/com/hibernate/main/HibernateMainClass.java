package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.CustomerDTO;
import com.hibernate.model.TransactionDTO;

public class HibernateMainClass {

	public static void main(String[] args) {
		try {

			TransactionDTO txn = buildDemoTransaction();
			Configuration configuration = new Configuration();
			configuration.configure();

			System.out.println("Hibernate Annotation Configuration loaded");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			System.out.println("Hibernate Annotation serviceRegistry created");

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			Session session = sessionFactory.openSession();

			Transaction tx = session.beginTransaction();

			session.save(txn);

			/*CustomerDTO t1 = (CustomerDTO) session.get(CustomerDTO.class, new Long(17));
			TransactionDTO t2 = (TransactionDTO) session.get(TransactionDTO.class, new Long(17));
			t2.setCustomer(null);
			System.out.println("fetching... "+ t1.getAddress() +","+t1.getEmail());
			session.delete(t1);*/

			tx.commit();
			// System.out.println("deleted");
			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static TransactionDTO buildDemoTransaction() {
		TransactionDTO txn = new TransactionDTO();
		txn.setDate(new Date());
		txn.setTotal(300);

		CustomerDTO cust = new CustomerDTO();
		cust.setAddress("belgaum");
		cust.setEmail("xyz@gmail.com");
		cust.setName("xyz");

		txn.setCustomer(cust);

		cust.setTxn(txn);
		return txn;
	}

}
