package com.example.repositories;

import com.example.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//	@Query("SELECT e FROM Employee e WHERE rownum < 11 ORDER BY e.id")
//	List<Employee> find10Id();

//	 List<Employee> findTop10ByOrderById();

}
