package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Sim;

public class TestGetMobileById_Sim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 3);
		if (mobile != null) {
			System.out.println("----------------------------------------------");
			System.out.println("Mobile name: " + mobile.getName());
			System.out.println("Mobile cost: " + mobile.getCost());
			System.out.println("----------------------------------------------");

			List<Sim> sims = mobile.getSims();
			for (Sim sim : sims) {
				System.out.println("Sim ID: " + sim.getId());
				System.out.println("Sim provider: " + sim.getProvider());
				System.out.println("Sim type: " + sim.getType());
				System.out.println("-------------------------------------------");
			}
		} else {
			System.out.println("No such id found");
		}
	}
}
