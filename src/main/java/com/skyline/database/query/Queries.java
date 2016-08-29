package com.skyline.database.query;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.skyline.database.EntityManagerUtil;
import com.skyline.database.entity.Owner;

public class Queries {
	
	private static EntityManager em = EntityManagerUtil.getEntityManager();
	
	public static Owner getOwnerByLogin(String login) {
		TypedQuery<Owner> q = em.createQuery(
				"SELECT o " +
				"FROM Owner o " +
				"WHERE o.login = ?1", Owner.class)
				.setParameter(1, login);
		try {
			return q.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
