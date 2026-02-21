package com.school.dao;
import com.school.entity.Principal;
import com.school.entity.School;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class DAO_Principal
{
	public static void addPrincipal (int id, String name)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Principal principal = new Principal ();
		principal.setId (id);
		principal.setName (name);
		transaction.begin ();
		manager.persist (principal);
		transaction.commit ();
		manager.close ();
	}
	public static void readPrincipal (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		Principal principal = manager.find (Principal.class, id);
		if (principal != null)
		{
			System.out.println ("Principal Id: " + principal.getId ());
			System.out.println ("Principal Name: " + principal.getName ());
			System.out.println ("Principal School: " + principal.getSchool ());
		}
		else
		{
			System.out.println ("Principal Not Found");
		}
		manager.close ();
	}
	public static void updatePrincipal (int id, String name)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Principal principal = manager.find (Principal.class, id);
		if (principal != null)
		{
			transaction.begin ();
			principal.setName (name);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Principal Not Found");
		}
		manager.close ();
	}
	public static void deletePrincipal (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Principal principal = manager.find (Principal.class, id);
		if (principal != null)
		{
			transaction.begin ();
			manager.remove (principal);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Principal Not Found");
		}
		manager.close ();
	}
	public static void assignPrincipalToSchool (int pid, int sid)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Principal principal = manager.find (Principal.class, pid);
		School school = manager.find (School.class, sid);
		if (principal != null && school != null)
		{
			transaction.begin ();
			principal.setSchool (school);
			school.setPrincipal (principal);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Principal Not Found");
		}
		manager.close ();
	}
	public static void removePrincipalFromSchool (int pid)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Principal principal = manager.find (Principal.class, pid);
		if (principal != null && principal.getSchool () != null)
		{
			transaction.begin ();
			School school = principal.getSchool ();
			school.setPrincipal (null);
			principal.setSchool (null);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Principal Or School Not Found");
		}
		manager.close ();
	}
}