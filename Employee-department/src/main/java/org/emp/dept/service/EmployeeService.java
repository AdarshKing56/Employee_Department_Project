package org.emp.dept.service;

import java.util.List;
import java.util.Optional;

import org.emp.dept.dao.DepartmentDao;
import org.emp.dept.dao.EmployeeDao;
import org.emp.dept.dto.Department;
import org.emp.dept.dto.Employee;
import org.emp.dept.dto.ResponseStructure;
import org.emp.dept.exception.InvalidEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	ResponseStructure<Employee> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee, int deptId) {
		Optional<Department> db = departmentDao.findDepartmentById(deptId);
		if (db.isPresent()) {
			Department department = db.get();
			department.getEmployee().add(employee);
			employee.setDepartment(department);
			departmentDao.saveDepartment(department);
			structure.setData(employeeDao.saveEmployee(employee));
			structure.setMessage("Employee Saved successfuly");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
		}
		throw new InvalidEmployeeException("Employee cant not Save with this Id");
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee) {
		Optional<Employee> dbOptional = employeeDao.findById(employee.getEmpId());
		if (dbOptional.isPresent()) {
			Employee dbEmployee = dbOptional.get();
			dbEmployee.setDepartment(employee.getDepartment());
			dbEmployee.setName(employee.getName());
			dbEmployee.setEmail(employee.getEmail());
			dbEmployee.setPhone(employee.getPhone());
			
			structure.setData(employeeDao.saveEmployee(employee));
			structure.setMessage("employee Updated successfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.ACCEPTED);
		}
		throw new InvalidEmployeeException("Invalid Employee Id");
	}


	public ResponseEntity<ResponseStructure<List<Employee>>> findByDepartmentId(int dept_id) {
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		List<Employee> dbOptional = employeeDao.findByDepartmentId(dept_id);
		if (dbOptional.size() > 0) {
			structure.setData(dbOptional);
			structure.setMessage("Finding successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		}
		throw new InvalidEmployeeException("Invalid Admin Id");
	}

}
