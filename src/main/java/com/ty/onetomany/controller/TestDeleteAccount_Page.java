package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.FBAccount;
import com.ty.onetomany.dto.FBPage;

public class TestDeleteAccount_Page {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		//whenever we delete a parent entity, delete the child entity first and delete parent. else
		// child entity becomes junk
		FBAccount fbaccount = entityManager.find(FBAccount.class, 2);
		
		List<FBPage> pages = fbaccount.getPages();
		
		entityTransaction.begin();
		for(FBPage page : pages) {
			entityManager.remove(page);
		}
		entityManager.remove(fbaccount);
		
		entityTransaction.commit();
	}
}
