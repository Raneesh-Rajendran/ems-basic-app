package com.ranae.ems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranae.ems.exception.ResourceNotFoundException;
import com.ranae.ems.model.Employee;
import com.ranae.ems.model.Payments;
import com.ranae.ems.repository.EmployeeRepository;
import com.ranae.ems.repository.PaymentRepository;

@CrossOrigin(origins = {"http://localhost:4200", "https://ems-basic-app.nw.r.appspot.com"})
@RestController
@RequestMapping("/ems/api/v1")
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees/payments")
	public List<Payments> getAllEmployees() {
		return paymentRepository.findAll();
	}
	
	@PostMapping("/employees/payments")
	public Payments createEmployee(@RequestBody Payments payment) {
		Optional<Employee> employee = employeeRepository.findById(payment.getEmployee().getEmpId());
		if (employee.isPresent())
			payment.setEmployee(employee.get());
		return paymentRepository.save(payment);
	}
	
	@DeleteMapping("/employees/payments/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long payId)
			throws ResourceNotFoundException {
		Payments payment = paymentRepository.findById(payId)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id :: " + payId));
		paymentRepository.delete(payment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
