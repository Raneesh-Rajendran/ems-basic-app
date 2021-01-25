import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Observable } from "rxjs";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Department } from '../department';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  department: Department = new Department();
  submitted = false;
  dropBox = true;
  departments: Promise<Department[]>;

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit() {
    this.getDepartmentList();
  }

  getDepartmentList() {
    this.departments = this.employeeService.getDepartmentList().then();
    this.employee.department = this.department;
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save() {
    this.employeeService
      .createEmployee(this.employee).subscribe(data => {
        console.log(data)
        this.employee = new Employee();
        this.gotoList();
      },
        error => console.log(error));
  }

  changeDepartment(value: string) {
    this.dropBox = true;
    if (this.employee.department.deptName=="true"){
      this.employee.department.deptName = "";
      this.dropBox=false;
    }
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }
}
