package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.BankAccount;
import com.ty.onetomany.dto.Person;

public class TestDeletePerson_BankAccount {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = entityManager.find(Person.class, 1);
		List<BankAccount> accounts = person.getBankAccount();
		
		entityTransaction.begin();
		for(BankAccount account : accounts) {
			entityManager.remove(account);
		}
		entityManager.remove(person);
		entityTransaction.commit();
	}
}
