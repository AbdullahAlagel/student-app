package com.abdull.demo.spring.boot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdull.demo.spring.boot.demo.dto.StudentDto;
import com.abdull.demo.spring.boot.demo.entity.Student;
import com.abdull.demo.spring.boot.demo.serviceimpl.StudentServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class StudentController {

	private StudentServiceImpl studentService;

//	localhost:8080/api/v1/student
//	{
//	    "firstName":"Ali",
//	    "lastName":"Sami",
//	    "address":"Hail",
//	    "phone":"0595963299"
//	}
	@PostMapping(value = "/api/v1/student")
	public Student addNewStudent(@Valid @RequestBody StudentDto dto) {
		return studentService.addNewStudent(dto);
	}

//	localhost:8080/api/v1/find/1
	@GetMapping(value = "/api/v1/find/{id}")
	public Student findStudentById(@PathVariable(name = "id") Long id) {
		return studentService.findStudentById(id);
	}
	
	@GetMapping(value = "/api/v1/address/{address}")
	public Student findtByAddress(@PathVariable(name = "address") String address) {
		return studentService.findByAddress(address);
	}
	
	@GetMapping(value = "/api/v1/first-name/{firstname}")
	public Student findByFirstName(@PathVariable(name = "firstname") String firstname) {
		return studentService.findByFirstName(firstname);
	}
//	localhost:8080/api/v1/find
	@GetMapping(value = "/api/v1/find")
	public List<Student> findAllStudent() {
		return studentService.findAllStudent();
	}

	@PutMapping(value = "/api/v1/update/{id}")
	public Student updateStudentById(@PathVariable(name = "id") Long id,
			@Valid @RequestBody StudentDto dto) {
		return studentService.updateStudentById(id,dto);
	}
	
//	localhost:8080/api/v1/delete/1
	@DeleteMapping(value = "/api/v1/delete/{id}")
	public String deleteStudentById(@PathVariable(name = "id") Long id) {
		studentService.deleteStudentById(id);
		return "Student Remove Successfuly";
	}
}
