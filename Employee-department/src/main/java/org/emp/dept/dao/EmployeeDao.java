package org.emp.dept.dao;

import java.util.List;
import java.util.Optional;

import org.emp.dept.dto.Employee;
import org.emp.dept.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Optional<Employee> findById(int empId) {
		return employeeRepository.findById(empId);
	}
	
	public List<Employee> findByDepartmentId(int department_id) {
		return employeeRepository.findByDepartmentId(department_id);
	}

}
