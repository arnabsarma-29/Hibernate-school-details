package com.school.dao;
import com.school.entity.School;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class DAO_School
{
	public static void addSchool (int id, String name)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		School school = new School ();
		school.setId (id);
		school.setName (name);
		transaction.begin ();
		manager.persist (school);
		transaction.commit ();
		manager.close ();
	}
	public static void readSchool (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		School school = manager.find (School.class, id);
		if (school != null)
		{
			System.out.println ("School Id: " + school.getId ());
			System.out.println ("School Name: " + school.getName ());
			System.out.println ("School's Principal: " + school.getPrincipal ());
			System.out.println ("School Students: " + school.getStudents ());
			System.out.println ("School Teachers: " + school.getTeachers ());
			System.out.println ("School Subjects: " + school.getSubjects ());
		}
		else
		{
			System.out.println ("School Not Found");
		}
		manager.close ();
	}
	public static void updateSchool (int id, String name)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		School school = manager.find (School.class, id);
		if (school != null)
		{
			transaction.begin ();
			school.setName (name);
			transaction.commit ();
		}
		else
		{
			System.out.println ("School Not Found");
		}
		manager.close ();
	}
	public static void deleteSchool (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		School school = manager.find (School.class, id);
		if (school != null)
		{
			transaction.begin ();
			manager.remove (school);
			transaction.commit ();
		}
		else
		{
			System.out.println ("School Not Found");
		}
		manager.close ();
	}
}