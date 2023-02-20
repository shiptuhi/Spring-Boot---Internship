package com.example.repositories;

import com.example.models.Department;
import com.example.models.Employee;
import com.example.repositories.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.sql.* ;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Repositories {
	
	Connection conn = null ;

	@Autowired
	EntityManager entityManager;

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Department> find10Id() {
//		String hql = "SELECT e.id FROM Department e";
		String hql = "FROM Department d WHERE rownum < 11 " + "ORDER BY d.id";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	public List<Employee> find() {
//		String hql = "FROM Employee e WHERE e.id = 198";
		String hql = "SELECT e FROM Employee e ";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	public Employee insert(Employee newemployee){
		
		Employee emp = new Employee();
		emp.setId(newemployee.getId());
		emp.setFirstName(newemployee.getFirstName());
		emp.setLastName(newemployee.getLastName());
		emp.setEmail(newemployee.getEmail());
		emp.setPhoneNo(newemployee.getPhoneNo());
		emp.setDate(newemployee.getDate());
		emp.setJobId(newemployee.getJobId());
		emp.setSalary(newemployee.getSalary());
		emp.setComPCT(newemployee.getComPCT());
		emp.setManID(newemployee.getManID());
		emp.setDepartment(newemployee.getDepartment());

		return employeeRepository.save(emp);
	}

	public Employee upEmployee(long id, Employee employee) {
		Employee emp = employeeRepository.findById(id).get();
		emp.setFirstName(employee.getFirstName());
		return employeeRepository.save(emp);
	}

}
