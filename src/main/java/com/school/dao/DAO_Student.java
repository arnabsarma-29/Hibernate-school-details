package com.school.dao;
import com.school.entity.School;
import com.school.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class DAO_Student
{
	public static void addStudent (int id, String name)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Student student = new Student ();
		student.setId (id);
		student.setName (name);
		transaction.begin ();
		manager.persist (student);
		transaction.commit ();
		manager.close ();
	}
	public static void readStudent (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		Student student = manager.find (Student.class, id);
		if (student != null)
		{
			System.out.println ("Student Id: " + student.getId ());
			System.out.println ("Student Name: " + student.getName ());
			System.out.println ("Student School: " + student.getSchool ());
			System.out.println ("Student Subjects: " + student.getSubjects ());
			System.out.println ("Student Teachers: " + student.getAllTeachers());
		}
		else
		{
			System.out.println ("Student Not Found");
		}
		manager.close ();
	}
	public static void updateStudent (int id, String name)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Student student= manager.find (Student.class, id);
		if (student != null)
		{
			transaction.begin ();
			student.setName (name);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Student Not Found");
		}
		manager.close ();
	}
	public static void deleteStudent (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Student student = manager.find (Student.class, id);
		if (student != null)
		{
			transaction.begin ();
			student.getSubjects ().forEach (sub -> sub.getStudents ().remove (student));
			student.getSubjects ().clear ();
			manager.remove (student);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Student Not Found");
		}
		manager.close ();
	}
	public static void assignStudentToSchool (int stid, int scid)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Student student = manager.find (Student.class, stid);
		School school = manager.find (School.class, scid);
		if (student != null && school != null)
		{
			transaction.begin ();
			student.setSchool (school);
			school.getStudents ().add (student);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Student Not Found");
		}
		manager.close ();
	}
	public static void removeStudentFromSchool (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Student student = manager.find (Student.class, id);
		if (student != null && student.getSchool () != null)
		{
			transaction.begin ();
			School school = student.getSchool ();
			school.getStudents ().remove (student);
			student.setSchool (null);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Student Or School Not Found");
		}
		manager.close ();
	}
}