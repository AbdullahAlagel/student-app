package com.abdull.demo.spring.boot.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class StudentDto {

	@NotBlank(message = "First Name must be not null")
	private String firstName;
	@NotBlank(message = "Last Name must be not null")
	private String lastName;
	@NotBlank(message = "Address must be not null")
	private String address;
	@NotBlank(message = "Phone must be not null")
	@Size(max = 10,min = 10)
	private String phone;
}
