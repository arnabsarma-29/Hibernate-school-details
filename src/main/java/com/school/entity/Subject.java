package com.school.entity;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Subject
{
	@Id
	private int id;
	private String name;
	@ManyToOne
	private School school;
	@ManyToMany (mappedBy = "subjects")
	private Set <Teacher> teachers = new HashSet <> ();
	@ManyToMany (mappedBy = "subjects")
	private Set <Student> students = new HashSet <> ();
	public int getId ()
	{
		return id;
	}
	public void setId (int id)
	{
		this.id = id;
	}
	public String getName ()
	{
		return name;
	}
	public void setName (String name)
	{
		this.name = name;
	}
	public School getSchool ()
	{
		return school;
	}
	public void setSchool (School school)
	{
		this.school = school;
	}
	public Set <Teacher> getTeachers ()
	{
		return teachers;
	}
	public void addTeacher (Teacher tch)
	{
		teachers.add (tch);
		tch.getSubjects ().add (this);
	}
	public void removeTeacher (Teacher tch)
	{
		teachers.remove (tch);
		tch.getSubjects ().remove (this);
	}
	public Set <Student> getStudents ()
	{
		return students;
	}
	public void addStudent (Student stu)
	{
		students.add (stu);
		stu.getSubjects ().add (this);
	}
	public void removeStudent (Student stu)
	{
		students.remove (stu);
		stu.getSubjects ().remove (this);
	}
	@Override
	public String toString ()
	{
		return "Subject { id = " + id + ", name = " + name + " }";
	}
}