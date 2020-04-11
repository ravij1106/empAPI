package com.empApi.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empApi.entity.Designation;
import com.empApi.entity.Employee;
import com.empApi.service.EmployeeService;

@RestController
public class homeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping()
	public Page<Employee> findAll(Pageable pageable) {
		return empService.findAll(pageable);
	}
	
	@GetMapping("/search/")
	public Page<Employee> search(Pageable pageable,@RequestParam("name") String searchText) {
		return  empService.search(pageable,searchText);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable("id") Long id) {
		return empService.findById(id)
				.map(user -> ResponseEntity.ok().body(user))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping()
	public Employee save(@RequestBody Employee emp) throws ParseException {
		Employee e = new Employee();
		e.setEmpName(emp.getEmpName());
		e.setEmpDesignation(emp.getEmpDesignation());
		e.setJoinDate(emp.getJoinDate());
		return empService.save(e);
	}
	
	@PutMapping()
	public Employee update(@RequestBody Employee emp) throws ParseException {
		Employee e = new Employee();
		e.setId(emp.getId());
		e.setEmpName(emp.getEmpName());
		e.setEmpDesignation(emp.getEmpDesignation());
		e.setJoinDate(emp.getJoinDate());
		return empService.save(e);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return empService.findById(id)
				.map(user -> {
					empService.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	
	}
}
