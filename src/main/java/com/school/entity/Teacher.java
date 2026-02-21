package com.school.entity;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Teacher
{
	@Id
	private int id;
	private String name;
	@ManyToOne
	private School school;
	@ManyToMany
	private Set <Subject> subjects = new HashSet <> ();
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
	public Set <Subject> getSubjects ()
	{
		return subjects;
	}
	public Set <Student> getAllStudents ()
	{
		return subjects.stream ().flatMap (s -> s.getStudents ().stream ()).collect (Collectors.toSet ());
	}
	@Override
	public String toString ()
	{
		return "Teacher { id = " + id + ", name = " + name + " }";
	}
}