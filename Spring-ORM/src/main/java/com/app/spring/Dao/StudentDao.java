package com.app.spring.Dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.app.spring.entity.Student;

public class StudentDao {
	HibernateTemplate hibernateTemplate;

	// Insert Student
	@Transactional
	public int insert(Student student) {
		Integer no = (Integer) this.hibernateTemplate.save(student);
		
		return no;

	}

	// Read Single Student
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		System.out.println(student);
		return student;
	}

	// ReadAll Student
	public List<Student> getAllStudent() {
		List<Student> student = this.hibernateTemplate.loadAll(Student.class);
		for (Student student2 : student) {
			System.out.println(student2);
		}
		return student;
	}

	// Deleting Student
	@Transactional
	public void deleteStudent(int studentId) {

		try {
			Student student = this.hibernateTemplate.get(Student.class, studentId);
			this.hibernateTemplate.delete(student);
			System.out.println("Student Deleted\n");
		} catch (Exception e) {
			System.out.println("not Deleted cheak it");
		}
	}

	// updating Student
	@Transactional
	public void updateStudent(Student student) {

		try {
			this.hibernateTemplate.update(student);
			System.out.println("Student is updated");
		} catch (Exception e) {
			System.out.println("Student Not Update ");
		}
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
