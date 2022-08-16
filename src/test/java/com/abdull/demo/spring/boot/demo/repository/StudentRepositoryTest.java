package com.abdull.demo.spring.boot.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.abdull.demo.spring.boot.demo.entity.Student;


@DataJpaTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository repository;
	
	@Autowired // it's a part of JPA Library 
	private TestEntityManager entityManager;
	
	
	@BeforeEach
	void setUp() {
		Student student = Student.builder()
				.firstName("Abdu")
				.lastName("Ala")
				.address("Rio")
				.phone("9999999999").build();
		// add Test Data To Student Entity 
		entityManager.persist(student);
	}
	

	@Test
	@DisplayName("Find Student By First Name")
	void testFindByFirstName_ThenReturnStudentOP() {
		Student student = repository.findByFirstName("Abdu").get();
		assertEquals(student.getFirstName(), "Abdu");
	}

	@Test
	@Disabled
	void testFindByFirstNameIgnoreCase() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("Find Student By Address")
	void testFindByAddress() {
		Student student = repository.findByAddress("Rio").get();
		assertEquals(student.getAddress(), "Rio");
	}

}
