import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from "rxjs";
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Payment } from '../payments';

@Component({
  selector: 'app-create-salary-payment',
  templateUrl: './create-salary-payment.component.html',
  styleUrls: ['./create-salary-payment.component.css']
})
export class CreateSalaryPaymentComponent implements OnInit {

  empId: number;
  payment: Payment = new Payment();
  submitted = false;

  constructor(private route: ActivatedRoute, private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit() {
    this.payment.employee = new Employee();

    this.empId = this.route.snapshot.params['id'];
    console.log(this.empId)
    this.payment.employee.empId = this.empId;
  }

  save() {
    console.log(this.payment)
    this.employeeService
      .paySalary(this.payment).subscribe(data => {
        console.log(data)
        this.payment = new Payment();
        this.gotoList();
      },
        error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }

}
