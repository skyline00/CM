package com.skyline.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
 
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carmaintainer");

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
