package com.school.dao;
import com.school.entity.School;
import com.school.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class DAO_Teacher
{
	public static void addTeacher (int id, String name)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Teacher teacher = new Teacher ();
		teacher.setId (id);
		teacher.setName (name);
		transaction.begin ();
		manager.persist (teacher);
		transaction.commit ();
		manager.close ();
	}
	public static void readTeacher (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		Teacher teacher = manager.find (Teacher.class, id);
		if (teacher != null)
		{
			System.out.println ("Teacher Id: " + teacher.getId ());
			System.out.println ("Teacher Name: " + teacher.getName ());
			System.out.println ("Teacher School: " + teacher.getSchool ());
			System.out.println ("Teacher Subjects: " + teacher.getSubjects ());
			System.out.println ("Teacher Students: " + teacher.getAllStudents ());
		}
		else
		{
			System.out.println ("Teacher Not Found");
		}
		manager.close ();
	}
	public static void updateTeacher (int id, String name)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Teacher teacher = manager.find (Teacher.class, id);
		if (teacher != null)
		{
			transaction.begin ();
			teacher.setName (name);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Teacher Not Found");
		}
		manager.close ();
	}
	public static void deleteTeacher (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Teacher teacher = manager.find (Teacher.class, id);
		if (teacher != null)
		{
			transaction.begin ();
			teacher.getSubjects ().forEach (sub -> sub.getTeachers ().remove (teacher));
			teacher.getSubjects ().clear ();
			manager.remove (teacher);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Teacher Not Found");
		}
		manager.close ();
	}
	public static void assignTeacherToSchool (int tid, int sid)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Teacher teacher = manager.find (Teacher.class, tid);
		School school = manager.find (School.class, sid);
		if (teacher != null && school != null)
		{
			transaction.begin ();
			teacher.setSchool (school);
			school.getTeachers ().add (teacher);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Teacher Not Found");
		}
		manager.close ();
	}
	public static void removeTeacherFromSchool (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Teacher teacher = manager.find (Teacher.class, id);
		if (teacher != null && teacher.getSchool () != null)
		{
			transaction.begin ();
			School school = teacher.getSchool ();
			school.getTeachers ().remove (teacher);
			teacher.setSchool (null);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Teacher Or School Not Found");
		}
		manager.close ();
	}
}