package com.codsoft.SMS.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.codsoft.SMS.dto.Student;

public class StudentDao {

	EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Student student=new Student();
	
	public void addStudent(Student student) {
		et.begin();
		em.persist(student);
		et.commit();
		
	}
	
	public Student viewStudentByRoll(int rollNumber) {
		Student student=em.find(Student.class, rollNumber);
		return student;
	}
	
	public void updateStudent(Student student) {
		et.begin();
		em.merge(student);
		et.commit();
	}
	
	public void deleteStudent(Student student) {
		et.begin();
		em.remove(student);
		et.commit();
	}
	
	public List<Student>getAllStudents(){
		Query query=em.createQuery("select a from Student a");
		return query.getResultList();
	}
}
