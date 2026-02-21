package com.school.dao;
import com.school.entity.School;
import com.school.entity.Student;
import com.school.entity.Subject;
import com.school.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class DAO_Subject
{
	public static void addSubject (int id, String name)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Subject subject = new Subject ();
		subject.setId (id);
		subject.setName (name);
		transaction.begin ();
		manager.persist (subject);
		transaction.commit ();
		manager.close ();
	}
	public static void addTeacherIntoSubject (int teach_id, int sub_id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Teacher teacher = manager.find (Teacher.class, teach_id);
		Subject subject = manager.find (Subject.class, sub_id);
		if (teacher != null && subject != null)
		{
			transaction.begin ();
			subject.addTeacher (teacher);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Subject Not Found");
		}
		manager.close ();
	}
	public static void addStudentIntoSubject (int stu_id, int sub_id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Student student = manager.find (Student.class, stu_id);
		Subject subject = manager.find (Subject.class, sub_id);
		if (student != null && subject != null)
		{
			transaction.begin ();
			subject.addStudent (student);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Subject Not Found");
		}
		manager.close ();
	}
	public static void readSubject (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		Subject subject = manager.find (Subject.class, id);
		if (subject != null)
		{
			System.out.println ("Subject Id: " + subject.getId ());
			System.out.println ("Subject Name: " + subject.getName ());
			System.out.println ("Subject School: " + subject.getSchool ());
			System.out.println ("Subject Students: " + subject.getStudents ());
			System.out.println ("Subject Teachers: " + subject.getTeachers ());
		}
		else
		{
			System.out.println ("Subject Not Found");
		}
		manager.close ();
	}
	public static void updateSubject (int id, String name)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Subject subject = manager.find (Subject.class, id);
		if (subject != null)
		{
			transaction.begin ();
			subject.setName (name);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Subject Not Found");
		}
		manager.close ();
	}
	public static void deleteSubject (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Subject subject = manager.find (Subject.class, id);
		if (subject != null)
		{
			transaction.begin ();
			manager.remove (subject);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Subject Not Found");
		}
		manager.close ();
	}
	public static void removeTeacherFromSubject (int teach_id, int sub_id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Teacher teacher = manager.find (Teacher.class, teach_id);
		Subject subject = manager.find (Subject.class, sub_id);
		if (teacher != null && subject != null)
		{
			transaction.begin ();
			subject.getTeachers ().remove (teacher);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Teacher Or Subject Not Found");
		}
		manager.close ();
	}
	public static void removeStudentFromSubject (int stu_id, int sub_id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Student student = manager.find (Student.class, stu_id);
		Subject subject = manager.find (Subject.class, sub_id);
		if (student != null && subject != null)
		{
			transaction.begin ();
			subject.getStudents ().remove (student);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Teacher Or Subject Not Found");
		}
		manager.close ();
	}
	public static void assignSubjectToSchool (int suid, int sid)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Subject subject = manager.find (Subject.class, suid);
		School school = manager.find (School.class, sid);
		if (subject != null && school != null)
		{
			transaction.begin ();
			subject.setSchool (school);
			school.getSubjects ().add (subject);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Subject Not Found");
		}
		manager.close ();
	}
	public static void removeSubjectFromSchool (int id)
	{
		EntityManager manager = EMFUtil.factory.createEntityManager ();
		EntityTransaction transaction = manager.getTransaction ();
		Subject subject = manager.find (Subject.class, id);
		if (subject != null && subject.getSchool () != null)
		{
			transaction.begin ();
			School school = subject.getSchool ();
			school.getSubjects ().remove (subject);
			subject.setSchool (null);
			transaction.commit ();
		}
		else
		{
			System.out.println ("Student Or School Not Found");
		}
		manager.close ();
	}
}