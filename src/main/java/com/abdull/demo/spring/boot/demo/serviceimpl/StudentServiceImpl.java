package com.abdull.demo.spring.boot.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abdull.demo.spring.boot.demo.dto.StudentDto;
import com.abdull.demo.spring.boot.demo.entity.Student;
import com.abdull.demo.spring.boot.demo.exception.StudentNotFoundException;
import com.abdull.demo.spring.boot.demo.repository.StudentRepository;
import com.abdull.demo.spring.boot.demo.service.StudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	private StudentRepository repository;

	@Override
	public Student addNewStudent(StudentDto studentDto) {
		Student student = new Student();
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setAddress(studentDto.getAddress());
		student.setPhone(studentDto.getPhone());
		return repository.save(student);
	}

	@Override
	public Student findStudentById(Long id) {
		Optional<Student> findById = repository.findById(id);
		if (findById.isEmpty()) {
			throw new StudentNotFoundException("Student Not Found");
		}
		return findById.get();
	}
	
	@Override
	public Student findByAddress(String address) {
		Optional<Student> findByAddress = repository.findByAddress(address);
		if (findByAddress==null) {
			throw new StudentNotFoundException("Address for Student Not Found");
		}
		return findByAddress.get();
	}
	
	@Override
	public Student findByFirstName(String firstName) {
		Optional<Student> findByFirstName = repository.findByFirstName(firstName);
		if (findByFirstName.isEmpty()) {
			throw new StudentNotFoundException("First Name for Student Not Found");
		}
		return findByFirstName.get();
	}

	@Override
	public List<Student> findAllStudent() {
		return repository.findAll();
	}
	
	@Override
	public void deleteStudentById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Student updateStudentById(Long id, StudentDto dto) {
		Optional<Student> studentFromDB = repository.findById(id);
		if (studentFromDB.isEmpty()) {
			throw new StudentNotFoundException("Student Not Found");
		}
		studentFromDB.get().setFirstName(dto.getFirstName());
		studentFromDB.get().setLastName(dto.getLastName());
		studentFromDB.get().setAddress(dto.getAddress());
		studentFromDB.get().setPhone(dto.getPhone());
		repository.save(studentFromDB.get());
		return studentFromDB.get();
	}

}
