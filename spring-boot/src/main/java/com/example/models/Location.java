package com.example.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "LOCATIONS")
@Data
public class Location {

	@Id
	@GeneratedValue
	@Column(name = "LOCATION_ID", nullable = false)
	private Long id;

	@Column(name = "STREET_ADDRESS", nullable = true)
	private String strAdd;

	@Column(name = "POSTAL_CODE", nullable = true)
	private String posCode;

	@Column(name = "CITY", nullable = false)
	private String city;

	@Column(name = "STATUS_PROVINCE", nullable = true)
	private String stPro;

	@Column(name = "COUNTRY_ID", nullable = true)
	private String counID;

	@Column(name = "COUNTRIES_COUNTRY_ID", nullable = true)
	private String councounID;

	@OneToMany(mappedBy = "locaID")
	@JsonBackReference
	private Set<Department> department;


}
