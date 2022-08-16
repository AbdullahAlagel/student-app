package com.abdull.demo.spring.boot.demo.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.abdull.demo.spring.boot.demo.entity.Student;
import com.abdull.demo.spring.boot.demo.repository.StudentRepository;

@SpringBootTest
class StudentServiceImplTest {

	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@MockBean
	private StudentRepository studentRepository;

	@BeforeEach
	void setUp(){
		Optional<Student> student = Optional.ofNullable(Student.builder()
				.firstName("Abdu")
				.lastName("Ala")
				.address("Rio")
				.phone("9999999999").build());
		
		Mockito.when(studentRepository.findByFirstName("Abdu"))
		.thenReturn(student);
	}
	
	
	@Test
	@Disabled
	@DisplayName("Get Student based on first name")
	void whenAddNewStudent_thenStudentShouldFound() {
		String firstName= "Abdu";
		Student studentFound = studentServiceImpl.findByFirstName(firstName);
		assertEquals("Sami", studentFound);
	}

	@Test
	@Disabled
	void testFindStudentById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testFindByAddress() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testFindByFirstName() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testFindAllStudent() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteStudentById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testUpdateStudentById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testStudentServiceImpl() {
		fail("Not yet implemented");
	}

}
