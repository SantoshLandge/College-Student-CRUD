package com.college.student.controller;

import com.college.student.model.Student;
import com.college.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
//@RequiredArgsConstructor
public class StudentController {
	
	private final IStudentService iStudentService;
	
	@Autowired
	public StudentController(IStudentService iStudentService) {
		this.iStudentService = iStudentService;
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudent() {
		return new ResponseEntity<>(iStudentService.getStudents(), HttpStatus.FOUND);
	}	
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return iStudentService.addStudent(student);
		
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
		return iStudentService.updateStudent(student, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable Long id) {
		iStudentService.deleteStudent(id);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return iStudentService.getStudentById(id);
	}

}
