package com.empApi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import com.empApi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee>{
	@Query("select emp From Employee emp where emp.empName = ?1 or emp.empDesignation = ?1")
	Page<Employee> search(Pageable pageable, String queriableText);

	@Query("select emp From Employee emp where emp.id = ?1")
	Employee retrieveUserById( Long id);
}
