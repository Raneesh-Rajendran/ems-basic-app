import { Employee } from '../employee';
import { Component, OnInit, Input } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Observable } from "rxjs";
import { map, filter } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';
import { Payment } from '../payments';
import { EmployeefilterPipe } from '../employeefilter.pipe';


@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id: number;
  payments: Observable<Payment[]>;
  employee: Employee;
  filterYear: string = "";
  totalSalary: number = 0;

  constructor(private route: ActivatedRoute, private router: Router,
    private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();
    this.id = this.route.snapshot.params['id'];

    this.reloadData(this.id);

    this.employeeService.getEmployee(this.id).then(data => {
        this.employee = data;
      }, error => console.log(error));
  }

  async reloadData(id: number) {
    await this.getPaymentList(id).then(result => {
      if (this.filterYear.length > 0)
        this.payments = result.filter(item => item.yearOfPayment.includes(this.filterYear));
      else
        this.payments = result;
      this.calculateTotalSalary(result);
    });
  }

  calculateTotalSalary(result: Payment[]) {
    let salary: number = 0;
    result.forEach(item => {
      salary = salary + item.amount;
    })
    this.totalSalary = salary;
  }

  async getPaymentList(id: number) {
    const payments = await this.employeeService.getEmployeeHistory(id);
    return payments;
  }

  deletePayment(pay: Payment) {
    this.employeeService.deletePayment(pay.payId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData(this.employee.empId);
        },
        error => console.log(error));
  }

  list() {
    this.router.navigate(['employees']);
  }
}
