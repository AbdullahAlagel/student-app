package com.abdull.demo.spring.boot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_Student")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "FIRST_NAME",columnDefinition = "varchar(50)")
	private String firstName;
	
	@Column(name = "LAST_NAME",columnDefinition = "varchar(50)")
	private String lastName;
	
	@Column(name = "ADDRESS",columnDefinition = "varchar(50)")
	private String address;
	
	@Column(name = "PHONE",columnDefinition = "varchar(15)")
	private String phone; 
}
