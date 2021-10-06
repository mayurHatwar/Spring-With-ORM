package com.app.spring.ORM;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.spring.Dao.StudentDao;
import com.app.spring.entity.Student;

public class MyMethod {
	Scanner scanner = new Scanner(System.in);
	ApplicationContext context = new ClassPathXmlApplicationContext("hibernate.xml");
	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

	public void insert() {
		Student student = new Student();
		System.out.println("Enter Student Id ");
		int no = scanner.nextInt();
		student.setId(no);
		System.out.println("Enter Student name ");
		String name = scanner.next();
		student.setName(name);
		System.out.println("Enter Student City ");
		String city = scanner.next();
		student.setCity(city);
		int no1 =studentDao.insert(student);
		if (no1 == 0) {
			System.out.println("Student not insert");
		}else {
			System.out.println("Student inserted");
		}
		

	}

	public void getAllStudent() {
		studentDao.getAllStudent();

	}

	public void deleteStudent() {
		getAllStudent();
		System.out.println("Select Student id Which do wantdelete");
		int id = scanner.nextInt();
		studentDao.deleteStudent(id);

	}
	public void updateStudent() {
		Student student = new Student();
		getAllStudent();
		System.out.println("Select Student id Which do want update");
		int id = scanner.nextInt();
		studentDao.getStudent(id);
		System.out.println("Enter Student name ");
		String name = scanner.next();
		student.setName(name);
		System.out.println("Enter Student City ");
		String city = scanner.next();
		student.setCity(city);
		studentDao.updateStudent(student);
		
	}

	public void getStudent() {
		System.out.println("Enter Stuent id");
		int id = scanner.nextInt();
		studentDao.getStudent(id);	
		
	}
}
