package org.emp.dept.repository;

import java.util.List;

import org.emp.dept.dto.Department;
import org.emp.dept.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	

}
