package org.emp.dept.controller;

import java.util.List;

import org.emp.dept.dto.Employee;
import org.emp.dept.dto.ResponseStructure;
import org.emp.dept.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;;
	
	@PostMapping("/{deptId}")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee emp,@PathVariable int deptId){
		return employeeService.saveEmployee(emp,deptId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee emp){
		return employeeService.updateEmployee(emp);
	}
	
	@GetMapping("/find-by-Id")
	public ResponseEntity<ResponseStructure<List<Employee>>> findByDepartmentId(@RequestParam int dept_id){
		return employeeService.findByDepartmentId(dept_id);
	
	}
}
