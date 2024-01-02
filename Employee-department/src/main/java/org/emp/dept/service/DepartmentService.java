package org.emp.dept.service;

import java.util.Optional;

import org.emp.dept.dao.DepartmentDao;
import org.emp.dept.dto.Department;
import org.emp.dept.dto.ResponseStructure;
import org.emp.dept.exception.LoginInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	ResponseStructure<Department> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Department>> saveDepartment(Department department) {
		structure.setData(departmentDao.saveDepartment(department));
		structure.setMessage("Department saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Department>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Department>> updateDepartment(Department department){
		Optional<Department> dbOptional=departmentDao.findDepartmentById(department.getId());
		if(dbOptional.isPresent()) {
			Department dbDepartment=dbOptional.get();
			dbDepartment.setName(department.getName());
			structure.setData(departmentDao.saveDepartment(department));
			structure.setMessage("Department updated successfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Department>>(structure,HttpStatus.ACCEPTED);
		}
		throw new LoginInvalidException("Id Not Present");
	}

	
	public ResponseEntity<ResponseStructure<Department>> findDepartmentById(int id){
		Optional<Department> dbOptional=departmentDao.findDepartmentById(id);
		if(dbOptional.isPresent()) {
			structure.setData(dbOptional.get());
			structure.setMessage("Finding successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Department>>(structure,HttpStatus.OK);
		}
		throw new LoginInvalidException("Invalid Id");
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteDepartment(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Department> dbUser = departmentDao.findDepartmentById(id);
		if (dbUser.isPresent()) {
			departmentDao.delete(id);
			structure.setMessage("Department Deleted");
			structure.setData("Department Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setMessage("Department Not Deleted");
		structure.setData("Department Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
