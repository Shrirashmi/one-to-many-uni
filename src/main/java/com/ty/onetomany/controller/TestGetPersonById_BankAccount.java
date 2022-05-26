package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.border.EtchedBorder;

import com.ty.onetomany.dto.BankAccount;
import com.ty.onetomany.dto.Person;


public class TestGetPersonById_BankAccount {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		
		Person person = entityManager.find(Person.class, 1);
		List<BankAccount> accounts = person.getBankAccount();
		
		System.out.println("**************************************");
		System.out.println("Person Name: " + person.getName());
		System.out.println("Email: " + person.getEmail());
		System.out.println("Password: " + person.getPassword());
		
		for(BankAccount account : accounts) {
			System.out.println("ID: "  +account.getId());
			System.out.println("Account Number: " + account.getAccountNumber());
			System.out.println("IFSC Code" + account.getIfscCode());
			System.out.println("------------------------------------");
		}
	}
}
