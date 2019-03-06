package gr.pr.udemy.rest.spring.controller;

import gr.pr.udemy.rest.spring.entity.Student;
import gr.pr.udemy.rest.spring.entity.StudentErrorResponse;
import gr.pr.udemy.rest.spring.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	//@PostConstruct will make the method called only once
	@PostConstruct
	public void loadCustomers() {
		students = new ArrayList<>();

		students.add(new Student("Panagiotis", "Ressos"));
		students.add(new Student("Gerasimos", "Kotsovos"));
		students.add(new Student("Angel", "Perlianis"));
	}

	@GetMapping("/students")
	public List<Student> getStudents(){

		return students;

	}

	@GetMapping("/students/{studentId}")
	public Student getStudentsById(@PathVariable("studentId") int studentId){

		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id not found in the list. \nid: " + studentId);
		}

		return students.get(studentId);

	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handle404Exception(StudentNotFoundException exception) {

		StudentErrorResponse error = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleBadDataException(Exception exception) {

		StudentErrorResponse error = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
