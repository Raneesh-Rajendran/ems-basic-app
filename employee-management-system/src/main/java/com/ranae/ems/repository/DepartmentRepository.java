package com.ranae.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ranae.ems.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	Department findByDeptName(String deptName);

}
