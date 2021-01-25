package com.ranae.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PAY_SEQ")
	@TableGenerator(name = "PAY_SEQ", initialValue = 13)
	@Column(name = "pay_id")
	private Long payId;
	
	@Column(name = "day", nullable = false)
	private String dayOfPayment;
	
	@Column(name = "month", nullable = false)
	private String monthOfPayment;
	
	@Column(name = "year", nullable = false)
	private String yearOfPayment;
	
	@Column(name = "salary", nullable = false)
	private Float amount;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
	public Payments(Long payId, String dayOfPayment, String monthOfPayment, String yearOfPayment, Float amount,
			Employee employee) {
		this.payId = payId;
		this.dayOfPayment = dayOfPayment;
		this.monthOfPayment = monthOfPayment;
		this.yearOfPayment = yearOfPayment;
		this.amount = amount;
		this.employee = employee;
	}

	public Payments() {
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Long getPayId() {
		return payId;
	}

	public void setPayId(Long payId) {
		this.payId = payId;
	}

	public String getDayOfPayment() {
		return dayOfPayment;
	}

	public void setDayOfPayment(String dayOfPayment) {
		this.dayOfPayment = dayOfPayment;
	}

	public String getMonthOfPayment() {
		return monthOfPayment;
	}

	public void setMonthOfPayment(String monthOfPayment) {
		this.monthOfPayment = monthOfPayment;
	}

	public String getYearOfPayment() {
		return yearOfPayment;
	}

	public void setYearOfPayment(String yearOfPayment) {
		this.yearOfPayment = yearOfPayment;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Payments [payId=" + payId + ", dayOfPayment=" + dayOfPayment + ", monthOfPayment=" + monthOfPayment
				+ ", yearOfPayment=" + yearOfPayment + ", amount=" + amount + ", employee=" + employee + "]";
	}

}
