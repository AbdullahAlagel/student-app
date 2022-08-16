package com.abdull.demo.spring.boot.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.abdull.demo.spring.boot.demo.dto.StudentDto;
import com.abdull.demo.spring.boot.demo.entity.Student;
import com.abdull.demo.spring.boot.demo.serviceimpl.StudentServiceImpl;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentServiceImpl studentService;
	
	private Student student;

	@BeforeEach
	void setUp() {
		 student = Student.builder()
				.firstName("Abdu")
				.lastName("Ala")
				.address("Rio")
				.phone("9999999999")
				.id(1l) // we add id here for Test 
				.build();
	}

	@Test
	@DisplayName("Save Student Test Data")
	void saveStudent_Test() throws Exception {
		StudentDto InputStudent = StudentDto.builder()
				.firstName("Abdu")
				.lastName("Ala")
				.address("Rio")
				.phone("9999999999")
				.build();

		Mockito.when(studentService.addNewStudent(InputStudent)).thenReturn(student);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/student")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"firstName\":\"Abdu\",\r\n"
						+ "    \"lastName\":\"Ala\",\r\n"
						+ "    \"address\":\"Rio\",\r\n"
						+ "    \"phone\":\"9999999999\"\r\n"
						+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	

	@Test
	@DisplayName("Find Student By First Name Test Case")
	void findStudentByFirstName_Test() throws Exception {
		Mockito.when(studentService.findByFirstName("Abdu")).thenReturn(student);
		// change path to real data [ /api/v1/first-name/{firstname} ]
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/first-name/Abdu")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.firstName").value(student.getFirstName()));
	}

}
