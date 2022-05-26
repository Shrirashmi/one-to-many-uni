package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Sim;

public class TestSaveMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Sim sim1 = new Sim();
		sim1.setProvider("Airtel");
		sim1.setType("3G");
		
		Sim sim2 = new Sim();
		sim2.setProvider("Jio");
		sim2.setType("4G");
		
		Sim sim3 = new Sim();
		sim3.setProvider("Idea");
		sim3.setType("3G");
		
		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		
		Mobile mobile1 = new Mobile();
		mobile1.setName("Motorola");
		mobile1.setCost(19000);
		
		mobile1.setSims(sims);

		
		entityTransaction.begin();
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(mobile1);
		entityTransaction.commit();
		
	}
}
