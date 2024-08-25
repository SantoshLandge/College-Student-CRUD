/**
 * 
 */
package com.college.student.repository;

import com.college.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author landge
 *
 */
public interface IStudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByEmail(String email);
	
}
