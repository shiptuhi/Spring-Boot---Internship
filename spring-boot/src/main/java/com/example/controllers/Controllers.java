package com.example.controllers;

import com.example.models.Department;
import com.example.models.Employee;
import com.example.repositories.Repositories;
import com.example.Service.KafkaProducer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controllers {
	@Autowired
	Repositories repositories;

	@Autowired
	KafkaProducer kafkaProducer;

	public Controllers(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@GetMapping("/getid")
	public List<Department> get10Departments() {
		List<Department> department = repositories.find10Id();
		return department;
	}

	@GetMapping("/gettable")
	public List<Employee> getEmployees() {
		List<Employee> employee = repositories.find();
		return employee;
	}

	@PostMapping(path = "/insert", consumes = { "application/json" })
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee newEmployee) {

		Employee employee = repositories.insert(newEmployee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update/{id}") 
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee uEmployee) {
		Employee employee = repositories.upEmployee(id, uEmployee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	@PostMapping(path = "/publish", consumes = { "application/json" })
	public ResponseEntity<String> publish(@RequestBody Department department) {

		kafkaProducer.sendData(department);
		return ResponseEntity.ok("New Department has been sent to kafka topic");
	}
}