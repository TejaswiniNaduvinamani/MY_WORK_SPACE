package com.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.CartDTO;
import com.hibernate.model.ItemDTO;
import com.hibernate.model.TransactionDTO;

public class HibernateOneToManyMain {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();

		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		CartDTO cart = new CartDTO();
		cart.setName("MyCart4");
		cart.setTotal(1500);

		ItemDTO item1 = new ItemDTO("item-7", 700, 7, cart);
		ItemDTO item2 = new ItemDTO("item-8", 800, 8, cart);

		

		cart.getItems().add(item1);
		cart.getItems().add(item2);

		//CartDTO t2 = (CartDTO) session.get(CartDTO.class, new Long(17));

		session.save(cart);
		/*session.save(item1);
		session.save(item2);*/
		tx.commit();
		session.close();
		sessionFactory.close();

	}

}
