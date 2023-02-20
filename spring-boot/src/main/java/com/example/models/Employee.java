package com.example.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "EMPLOYEES")
@Data
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID", nullable = false)
	private Long id;
	

	@Column(name = "FIRST_NAME", nullable = true)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "PHONE_NUMBER", nullable = true)
	private String phoneNo;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MMM-YY")
	@Column(name = "HIRE_DATE", nullable = false)
	private Date date;

	@Column(name = "JOB_ID", nullable = false)
	private String jobId;

	@Column(name = "SALARY", nullable = true)
	private String salary;

	@Column(name = "COMMISSION_PCT", nullable = true)
	private String comPCT;

	@Column(name = "MANAGER_ID", nullable = true)
	private String manID;

	@ManyToOne()
	@JoinColumn(name = "DEPARTMENT_ID", nullable = true)
	@JsonIgnore
	@JsonManagedReference
	private Department department;

}
