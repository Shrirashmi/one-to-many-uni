package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Sim;

public class TestDeleteMobile_Sim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		//whenever we delete a parent entity, delete the child entity first and delete parent. else
		// child entity becomes junk
		Mobile mobile = entityManager.find(Mobile.class, 3);
		
		List<Sim> sims = mobile.getSims();
		
		entityTransaction.begin();
		for(Sim sim : sims) {
			entityManager.remove(sim);
		}
		entityManager.remove(mobile);
		
		entityTransaction.commit();
	}
}
