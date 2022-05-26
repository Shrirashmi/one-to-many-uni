package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.BankAccount;
import com.ty.onetomany.dto.Person;

public class TestSavePersonBankAccount {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = new Person();
		person.setName("Rashmi");
		person.setEmail("rashmi@gmail.com");
		person.setPassword("ra1sh");
		List<BankAccount> bankAccounts = new ArrayList();
		
		BankAccount bankAccount1 = new BankAccount();
		bankAccount1.setAccountNumber(49895656645l);
		bankAccount1.setIfscCode("SBI121");
		bankAccount1.setName("SBI");
		bankAccounts.add(bankAccount1);
		
		BankAccount bankAccount2 = new BankAccount();
		bankAccount2.setAccountNumber(49895656645l);
		bankAccount2.setIfscCode("HDFC21");
		bankAccount2.setName("HDFC");
		bankAccounts.add(bankAccount2);
		person.setBankAccount(bankAccounts);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bankAccount1);
		entityManager.persist(bankAccount2);
		entityTransaction.commit();
	}
}
