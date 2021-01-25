package com.ranae.ems.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEPT_SEQ")
	@TableGenerator(name = "DEPT_SEQ", initialValue = 3)
	@Column(name="dept_id")
	private Long deptId;
	
	@Column(name = "dept_name", nullable = true)
	private String deptName;

	
	@OneToMany(mappedBy="department",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Set<Employee> employees;
	
	public Department() {
	}

	public Department(Long deptId, String deptName, Set<Employee> employees) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.employees = employees;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", employees=" + employees + "]";
	}
	
}
