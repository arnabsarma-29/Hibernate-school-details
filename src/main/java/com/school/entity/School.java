package com.school.entity;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class School
{
	@Id
	private int id;
	private String name;
	@OneToOne (mappedBy = "school", cascade = CascadeType.ALL)
	private Principal principal;
	@OneToMany (mappedBy = "school", cascade = CascadeType.ALL)
	private Set <Teacher> teacher = new HashSet <> ();
	@OneToMany (mappedBy = "school", cascade = CascadeType.ALL)
	private Set <Student> student = new HashSet <> ();
	@OneToMany (mappedBy = "school", cascade = CascadeType.ALL)
	private Set <Subject> subject = new HashSet <> ();
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
	public Principal getPrincipal ()
	{
		return principal;
	}
	public void setPrincipal (Principal principal)
	{
		this.principal = principal;
	}
	public Set<Teacher> getTeachers ()
	{
		return teacher;
	}
	public void setTeachers (Set <Teacher> teacher)
	{
		this.teacher = teacher;
	}
	public Set<Student> getStudents ()
	{
		return student;
	}
	public void setStudents (Set <Student> student)
	{
		this.student = student;
	}
	public Set<Subject> getSubjects ()
	{
		return subject;
	}
	public void setSubjects (Set <Subject> subject)
	{
		this.subject = subject;
	}
	@Override
	public String toString ()
	{
		return "School { id = " + id + ", name = " + name + " }";
	}
}