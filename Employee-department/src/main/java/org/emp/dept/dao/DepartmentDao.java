package org.emp.dept.dao;

import java.util.List;
import java.util.Optional;

import org.emp.dept.dto.Department;
import org.emp.dept.dto.Employee;
import org.emp.dept.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {

		return departmentRepository.save(department);
	}

	public Optional<Department> findDepartmentById(int id) {
		return departmentRepository.findById(id);
	}

	public boolean delete(int id) {
		Optional<Department> dBdep = findDepartmentById(id);
		if (dBdep.isPresent()) {
			departmentRepository.delete(dBdep.get());
			return true;
		}
		return false;
	}

	

}
