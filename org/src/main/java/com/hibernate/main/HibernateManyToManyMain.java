package com.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.CartShopDTO;
import com.hibernate.model.ItemShopDTO;

public class HibernateManyToManyMain {

	public static void main(String[] args) {

		ItemShopDTO item1 = new ItemShopDTO();
		item1.setDescription("moto");
		item1.setPrice(400);
		ItemShopDTO item2 = new ItemShopDTO();
		item2.setDescription("one plus");
		item2.setPrice(500);
		CartShopDTO cart = new CartShopDTO();
		cart.setTotal(900);
		Set<ItemShopDTO> items = new HashSet<ItemShopDTO>();
		items.add(item1);
		items.add(item2);
		cart.setItems(items);

		SessionFactory sessionFactory = null;

		try {
			Configuration config = new Configuration();
			config.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();

			sessionFactory = config.buildSessionFactory(serviceRegistry);

			Session session = sessionFactory.openSession();

			Transaction tx = session.beginTransaction();
			session.save(cart);
			System.out.println("Before committing transaction");
			tx.commit();
			sessionFactory.close();

			System.out.println("Cart ID=" + cart.getId());
			System.out.println("Item1 ID=" + item1.getId());
			System.out.println("Item2 ID=" + item2.getId());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessionFactory != null && !sessionFactory.isClosed())
				sessionFactory.close();
		}
	}

}
