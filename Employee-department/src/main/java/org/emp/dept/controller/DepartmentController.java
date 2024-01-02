package org.emp.dept.controller;

import java.util.List;

import org.emp.dept.dto.Department;
import org.emp.dept.dto.Employee;
import org.emp.dept.dto.ResponseStructure;
import org.emp.dept.service.DepartmentService;
import org.emp.dept.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Department>> saveDepartment(@RequestBody Department dept){
		return departmentService.saveDepartment(dept);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Department>> updateDepartment(@RequestBody Department dept){
		return departmentService.updateDepartment(dept);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Department>> findDepartmentById(@PathVariable int id){
		return departmentService.findDepartmentById(id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id){
		return departmentService.deleteDepartment(id);
	}
}
