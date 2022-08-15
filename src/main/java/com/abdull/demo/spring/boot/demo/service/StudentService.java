package com.abdull.demo.spring.boot.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abdull.demo.spring.boot.demo.dto.StudentDto;
import com.abdull.demo.spring.boot.demo.entity.Student;
@Service
public interface StudentService {

	
	public Student addNewStudent(StudentDto studentDto);
	
	public Student findStudentById(Long id);
	
	public List<Student> findAllStudent();
	
	public Student updateStudentById(Long id, StudentDto dto);
	
	public void deleteStudentById(Long id);
	
	public Student findByAddress(String address);
	
	public Student findByFirstName(String address);
}
