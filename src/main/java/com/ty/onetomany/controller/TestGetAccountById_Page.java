package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.FBAccount;
import com.ty.onetomany.dto.FBPage;

public class TestGetAccountById_Page {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		FBAccount fbAccount = entityManager.find(FBAccount.class, 2);
		if (fbAccount != null) {
			System.out.println("----------------------------------------------");
			System.out.println("Email: " + fbAccount.getEmail());
			System.out.println("Mobile No: " + fbAccount.getMobileNo());
			System.out.println("Name: " + fbAccount.getName());
			System.out.println("----------------------------------------------");
			List<FBPage> pages = fbAccount.getPages();
			for (FBPage page : pages) {
				if(page!=null) {
				System.out.println("Page Name: " + page.getName());
				System.out.println("Page Title: " + page.getTitle());
				System.out.println("Page Description: " + page.getDescription());
				System.out.println("-------------------------------------------");
				}
				else {
					System.out.println("No page for this account");
				}
			}
		}	
		else 
		{
				System.out.println("No such id found");
			}
	}
}
