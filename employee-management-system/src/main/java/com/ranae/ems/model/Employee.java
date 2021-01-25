package com.ranae.ems.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_SEQ")
	@TableGenerator(name = "EMP_SEQ", initialValue = 7)
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@Column(name = "email_address", nullable = false)
	private String emailId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "dept_id")
	private Department department;

	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Payments> historyOfPayments;

	public Employee() {

	}

	public Employee(Long empId, String firstName, String lastName, String emailId, Department department,
			Set<Payments> historyOfPayments) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.department = department;
		this.historyOfPayments = historyOfPayments;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Payments> getHistoryOfPayments() {
		return historyOfPayments;
	}

	public void setHistoryOfPayments(Set<Payments> historyOfPayments) {
		this.historyOfPayments = historyOfPayments;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", department=" + department + ", historyOfPayments=" + historyOfPayments + "]";
	}

}
