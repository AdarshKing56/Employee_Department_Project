package org.emp.dept.repository;

import java.util.List;

import org.emp.dept.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("select b from Employee b where b.department.id=?1")
	List<Employee> findByDepartmentId(int department_id);

}
