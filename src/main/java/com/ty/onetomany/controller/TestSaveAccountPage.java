package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.FBAccount;
import com.ty.onetomany.dto.FBPage;

public class TestSaveAccountPage {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		FBAccount account = new FBAccount();
		account.setEmail("rashmi@gmail.com");
		account.setPassword("rash");
		account.setMobileNo(99856897l);
		account.setName("Rashmi");
		
		FBPage page1 = new FBPage();
		page1.setName("Photography");
		page1.setTitle("PhotographY");
		page1.setDescription("i click pictures and post here");
		
		FBPage page2 = new FBPage();
		page2.setName("Motivation");
		page2.setTitle("MotivationalQuotes");
		page2.setDescription("i post motivationalQuotes here");
		
		List<FBPage> pages = new ArrayList<FBPage>();
		pages.add(page1);
		pages.add(page2);
		
		
		account.setPages(pages);
		
		entityTransaction.begin();
		entityManager.persist(account);
		entityManager.persist(page1);
		entityManager.persist(page2);
		entityTransaction.commit();
	}
}
