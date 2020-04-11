package com.empApi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.empApi.entity.Employee;

public interface EmployeeService extends IFinder<Employee>, IService<Employee>{
	Page<Employee> search(Pageable pageable, String searchText);

	Employee updateUser(Employee emp);
}
