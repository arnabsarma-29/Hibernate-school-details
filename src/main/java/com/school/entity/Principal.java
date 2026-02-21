package com.school.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Principal
{
	@Id
	private int id;
	private String name;
	@OneToOne
	private School school;
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
	@Override
	public String toString ()
	{
		return "Principal { id = " + id + ", name = " + name + " }";
	}
}