package com.empApi.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empApi.entity.Employee;
import com.empApi.repository.EmployeeRepository;
import com.empApi.service.BasicService;
import com.empApi.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends BasicService<Employee, EmployeeRepository> implements EmployeeService{

	@Override
	public Page<Employee> search(Pageable pageable, String searchText) {
		String queriableText = new StringBuilder("%").append(searchText).append("%").toString();
		return repository.search(pageable, queriableText);
	}

	@Override
	public Employee updateUser(Employee emp) {
		
		return null;
	}

}
