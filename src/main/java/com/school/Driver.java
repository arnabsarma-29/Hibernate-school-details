package com.school;
import java.util.Scanner;
import com.school.dao.DAO_Principal;
import com.school.dao.DAO_School;
import com.school.dao.DAO_Student;
import com.school.dao.DAO_Subject;
import com.school.dao.DAO_Teacher;
public class Driver
{
	public static void main (String [] args)
	{
		Scanner scn = new Scanner (System.in);
		boolean flag = true;
		while (flag)
		{
			System.out.println ("1. School");
			System.out.println ("2. Principal");
			System.out.println ("3. Subject");
			System.out.println ("4. Teacher");
			System.out.println ("5. Student");
			System.out.println ("0. Exit");
			System.out.print ("Input: ");
			int in = scn.nextInt ();
			switch (in)
			{
				case 0:
					flag = false;
					System.out.println ("Program Terminated");
					break;
				case 1:
					schoolMenu (scn);
					break;
				case 2:
					principalMenu (scn);
					break;
				case 3:
					subjectMenu (scn);
					break;
				case 4:
					teacherMenu (scn);
					break;
				case 5:
					studentMenu (scn);
					break;
				default:
					System.out.println ("Invalid Choice");
			}
		}
		scn.close ();
	}
	public static void schoolMenu (Scanner scn)
	{
		System.out.println ("1. Insert");
		System.out.println ("2. Read");
		System.out.println ("3. Update");
		System.out.println ("4. Delete");
		System.out.print ("Input: ");
		int in = scn.nextInt ();
		switch (in)
		{
			case 1:
				System.out.print ("Enter School Id: ");
				int id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter School Name: ");
				String name = scn.nextLine ();
				DAO_School.addSchool (id, name);
				break;

			case 2:
				System.out.print ("Enter School Id: ");
				DAO_School.readSchool (scn.nextInt ());
				break;
			case 3:
				System.out.print ("Enter School Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter New School Name: ");
				name = scn.nextLine ();
				DAO_School.updateSchool (id, name);
				break;
			case 4:
				System.out.print ("Enter School Id: ");
				DAO_School.deleteSchool (scn.nextInt ());
				break;
			default:
				System.out.print ("Invalid Choice");
		}
	}
	public static void principalMenu (Scanner scn)
	{
		System.out.println ("1. Insert");
		System.out.println ("2. Assign Principal To School");
		System.out.println ("3. Remove Principal From School");
		System.out.println ("4. Read");
		System.out.println ("5. Update");
		System.out.println ("6. Delete");
		System.out.print ("Input: ");
		int in = scn.nextInt ();
		switch (in)
		{
			case 1:
				System.out.print ("Enter The Principal Id: ");
				int id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The Principal Name: ");
				String name = scn.nextLine ();
				DAO_Principal.addPrincipal (id, name);
				break;
			case 2:
				System.out.print ("Enter The Principal Id: ");
				int pid = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The School Id: ");
				int sid = scn.nextInt ();
				DAO_Principal.assignPrincipalToSchool (pid, sid);
				break;
			case 3:
				System.out.print ("Enter The Principal Id:");
				id = scn.nextInt ();
				DAO_Principal.removePrincipalFromSchool (id);
				break;
			case 4:
				System.out.print ("Enter The Principal Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				DAO_Principal.readPrincipal (id);
				break;
			case 5:
				System.out.print ("Enter The Principal Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The New Principal Name: ");
				name = scn.nextLine ();
				DAO_Principal.updatePrincipal (id, name);
				break;
			case 6:
				System.out.print ("Enter The Principal Id: ");
				id = scn.nextInt ();
				DAO_Principal.deletePrincipal (id);
				break;
			default:
				System.out.print ("Invalid Choice");
		}
	}
	public static void subjectMenu (Scanner scn)
	{
		System.out.println ("1. Insert");
		System.out.println ("2. Assign Subject To School");
		System.out.println ("3. Remove Subject From School");
		System.out.println ("4. Read");
		System.out.println ("5. Update");
		System.out.println ("6. Delete");
		System.out.print ("Input: ");
		int in = scn.nextInt ();
		switch (in)
		{
			case 1:
				System.out.print ("Enter The Subject Id: ");
				int id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The Subject Name: ");
				String name = scn.nextLine ();
				DAO_Subject.addSubject (id, name);
				break;
			case 2:
				System.out.print ("Enter The Subject Id: ");
				int suid = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The School Id: ");
				int scid = scn.nextInt ();
				DAO_Subject.assignSubjectToSchool (suid, scid);
				break;
			case 3:
				System.out.print ("Enter The Subject Id: ");
				id = scn.nextInt ();
				DAO_Subject.removeSubjectFromSchool (id);
				break;
			case 4:
				System.out.print ("Enter The Subject Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				DAO_Subject.readSubject (id);
				break;
			case 5:
				System.out.print ("Enter The Subject Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The New Subject Name: ");
				name = scn.nextLine ();
				DAO_Subject.updateSubject (id, name);
				break;
			case 6:
				System.out.print ("Enter The Subject Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				DAO_Subject.deleteSubject (id);
				break;
			default:
				System.out.print ("Invalid Choice");
		}
	}
	public static void teacherMenu (Scanner scn)
	{
		System.out.println ("1. Insert");
		System.out.println ("2. Assign Teacher To School");
		System.out.println ("3. Remove Teacher From School");
		System.out.println ("4. Assign Teacher To Subject");
		System.out.println ("5. Remove Teacher From Subject");
		System.out.println ("6. Read");
		System.out.println ("7. Update");
		System.out.println ("8. Delete");
		System.out.print ("Input: ");
		int in = scn.nextInt ();
		switch (in)
		{
			case 1:
				System.out.print ("Enter The Teacher Id: ");
				int id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The Teacher Name: ");
				String name = scn.nextLine();
				DAO_Teacher.addTeacher (id, name);
				break;
			case 2:
				System.out.print ("Enter The Teacher Id: ");
				int tid = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The School Id: ");
				int sid = scn.nextInt ();
				DAO_Teacher.assignTeacherToSchool (tid, sid);
				break;
			case 3:
				System.out.print ("Enter The Teacher Id: ");
				id =scn.nextInt ();
				DAO_Teacher.removeTeacherFromSchool (id);
				break;
			case 4:
				System.out.print ("Enter The Teacher Id: ");
				int teach_id = scn.nextInt ();
				System.out.print ("Enter The Subject Id: ");
				int sub_id = scn.nextInt ();
				DAO_Subject.addTeacherIntoSubject (teach_id, sub_id);
				break;
			case 5:
				System.out.print ("Enter The Teacher Id: ");
				teach_id = scn.nextInt ();
				System.out.print ("Enter The Subject Id: ");
				sub_id = scn.nextInt ();
				DAO_Subject.removeTeacherFromSubject (teach_id, sub_id);
				break;
			case 6:
				System.out.print ("Enter The Teacher Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				DAO_Teacher.readTeacher (id);
				break;
			case 7:
				System.out.print ("Enter The Teacher Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The New Teacher Name: ");
				name = scn.nextLine ();
				DAO_Teacher.updateTeacher (id, name);
				break;
			case 8:
				System.out.print ("Enter The Teacher Id: ");
				id = scn.nextInt ();
				DAO_Teacher.deleteTeacher (id);
				break;
			default:
				System.out.print ("Invalid Choice");
		}
	}
	public static void studentMenu (Scanner scn)
	{
		System.out.println ("1. Insert");
		System.out.println ("2. Assign Student To School");
		System.out.println ("3. Remove Student From School");
		System.out.println ("4. Assign Student To Subject");
		System.out.println ("5. Remove Student From Subject");
		System.out.println ("6. Read");
		System.out.println ("7. Update");
		System.out.println ("8. Delete");
		System.out.print ("Input: ");
		int in = scn.nextInt ();
		switch (in)
		{
			case 1:
				System.out.print ("Enter The Student Id: ");
				int id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The Student Name: ");
				String name = scn.nextLine();
				DAO_Student.addStudent (id, name);
				break;
			case 2:
				System.out.print ("Enter The Student Id: ");
				int stid = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The School Id: ");
				int scid = scn.nextInt ();
				DAO_Student.assignStudentToSchool (stid, scid);
				break;
			case 3:
				System.out.print ("Enter The Student Id: ");
				id = scn.nextInt ();
				DAO_Student.removeStudentFromSchool (id);
				break;
			case 4:
				System.out.print ("Enter The Student Id: ");
				int stu_id = scn.nextInt ();
				System.out.print ("Enter The Subject Id: ");
				int sub_id = scn.nextInt ();
				DAO_Subject.addStudentIntoSubject (stu_id, sub_id);
				break;
			case 5:
				System.out.print ("Enter The Student Id: ");
				stu_id = scn.nextInt ();
				System.out.print ("Enter The Subject Id: ");
				sub_id = scn.nextInt ();
				DAO_Subject.removeStudentFromSubject (stu_id, sub_id);
				break;
			case 6:
				System.out.print ("Enter The Student Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				DAO_Student.readStudent (id);
				break;
			case 7:
				System.out.print ("Enter The Student Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				System.out.print ("Enter The New Student Name: ");
				name = scn.nextLine ();
				DAO_Student.updateStudent (id, name);
				break;
			case 8:
				System.out.print ("Enter The Student Id: ");
				id = scn.nextInt ();
				scn.nextLine ();
				DAO_Student.deleteStudent (id);
				break;
			default:
				System.out.print ("Invalid Choice");
		}
	}
}