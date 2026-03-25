# School Management System (Console-Based Java Application)

A Java console-based application that manages a school system using JPA (Hibernate). It supports CRUD operations and relationships between School, Principal, Teacher, Student, and Subject entities.

---

## Features

- Manage School (Create, Read, Update, Delete)
- Manage Principal (Assign/Remove from School)
- Manage Teachers
- Manage Students
- Manage Subjects
- Assign and remove relationships between:
  - School ↔ Principal
  - School ↔ Subject
  - Teacher ↔ Subject
  - Student ↔ Subject
  - Teacher ↔ School
  - Student ↔ School

---

## Tech Stack

- Language: Java
- ORM: Hibernate / JPA
- Database: MySQL / PostgreSQL (configurable via JPA setup)
- Interface: Console (CLI)
- Architecture: DAO Pattern + Entity Relationship Model

---

## Project Structure

```
src/main/java/com/school/
    Driver.java

src/main/java/com/school/entity/
    School.java
    Principal.java
    Teacher.java
    Student.java
    Subject.java

src/main/java/com/school/dao/
    DAO_School.java
    DAO_Principal.java
    DAO_Teacher.java
    DAO_Student.java
    DAO_Subject.java
    EMFUtil.java
```

---

## How It Works

- The application runs from `Driver.java`
- A menu-driven interface allows user input via Scanner
- Each option calls the corresponding DAO methods
- DAO layer handles all database operations using EntityManager
- Relationships are managed using JPA annotations like:
  - @OneToMany
  - @ManyToOne
  - @ManyToMany

---

## Menu Options

Main Menu:
- School Management
- Principal Management
- Subject Management
- Teacher Management
- Student Management

Each module supports:
- Insert
- Read
- Update
- Delete
- Assign / Remove relationships

---

## Example Features

- Assign a Teacher to a School
- Assign a Subject to a School
- Assign Students to Subjects
- Link Teachers with Subjects
- Remove relationships dynamically

---

## How to Run

1. Clone the repository
```
git clone https://github.com/your-username/school-management-system.git
```

2. Import into IDE

3. Configure the database in persistence.xml

4. Run Driver.java

---

## Key Concepts Used

- Object-Oriented Programming (OOP)
- JPA / Hibernate ORM
- Entity Relationships (One-to-Many, Many-to-Many)
- DAO Design Pattern
- Console-based menu system
- Transaction management

---

## Author

GitHub: https://github.com/your-username
