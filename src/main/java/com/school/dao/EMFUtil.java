package com.school.dao;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class EMFUtil
{
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory ("AS");
}