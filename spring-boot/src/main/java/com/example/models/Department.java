package com.example.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "DEPARTMENTS")
@Data
public class Department {

	@Id
	@GeneratedValue
	@Column(name = "DEPARTMENT_ID", nullable = false)
	private Long  id;

	@Column(name = "DEPARTMENT_NAME", nullable = false)
	private String depName;

	@Column(name = "MANAGER_ID", nullable = true)
	private String manID;

	@Column(name = "LOCATION_ID", nullable = true)
	private String locaID;

//    @ManyToOne()
//    @JoinColumn(name = "LOCATION_ID", nullable = true)
//    @JsonManagedReference
//    private Location locaID;

	@OneToMany(mappedBy = "department")
	@JsonBackReference
	private Set<Employee> employee;
}
