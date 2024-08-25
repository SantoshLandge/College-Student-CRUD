package com.college.student.service;

import com.college.student.model.Student;

import java.util.List;

public interface IStudentService {
	
	Student addStudent(Student student);
	
	List<Student> getStudents();
	
	Student updateStudent(Student student, Long id);
	
	Student getStudentById(Long id);
	
	void deleteStudent(Long id);

}
