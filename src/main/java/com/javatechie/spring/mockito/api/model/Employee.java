package com.javatechie.spring.mockito.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String dept;
}
