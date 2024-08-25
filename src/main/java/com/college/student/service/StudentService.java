/**
 * 
 */
package com.college.student.service;

import com.college.student.exception.StudentAlreadyExistsException;
import com.college.student.exception.StudentNotFoundException;
import com.college.student.model.Student;
import com.college.student.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author landge
 *
 */

@Service
//@RequiredArgsConstructor //Error -> it automatically generates a constructor for all final fields
public class StudentService implements IStudentService {

	private final IStudentRepository iStudentRepository;

	@Autowired
	public StudentService(IStudentRepository iStudentRepository) {
		this.iStudentRepository = iStudentRepository;
	}

	@Override
	public List<Student> getStudents() {
		return iStudentRepository.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub

		if (studentAlreadyExists(student.getEmail())) {
			throw new StudentAlreadyExistsException(student.getEmail() + " Already Exiats in Data!");
		}

		return iStudentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student, Long id) {

		return iStudentRepository.findById(id).map(existingStudent -> {
			// Update the details
			existingStudent.setFirstName(student.getFirstName());
			existingStudent.setLastName(student.getLastName());
			existingStudent.setEmail(student.getEmail());
			existingStudent.setDepartment(student.getDepartment());
			return iStudentRepository.save(existingStudent);
		}).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

	}

	@Override
	public Student getStudentById(Long id) {

		return iStudentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
	}

	@Override
	public void deleteStudent(Long id) {

		if (iStudentRepository.existsById(id))
			iStudentRepository.deleteById(id);
		else
			throw new StudentNotFoundException("Student not found with id: " + id);

	}

	private boolean studentAlreadyExists(String email) {

		return iStudentRepository.findByEmail(email).isPresent();
	}

}
