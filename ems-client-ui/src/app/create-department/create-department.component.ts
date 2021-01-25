import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Department } from '../department';
import { Observable } from "rxjs";
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-department',
  templateUrl: './create-department.component.html',
  styleUrls: ['./create-department.component.css']
})
export class CreateDepartmentComponent implements OnInit {

  departments: Observable<Department[]>;
  department: Department = new Department();
  submitted = false;

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

   getDeparmentList(){
    const departments =  this.employeeService.getDepartmentList();
    return departments;
  }

  save() {
    this.employeeService
      .createDepartment(this.department).subscribe(data => {
        console.log(data)
        this.department = new Department();
        this.reloadData();
      },
      error => console.log(error));
  }

  deleteDepartment(id:number){
    this.employeeService.deleteDepartment(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  async reloadData() {
    await this.getDeparmentList().then(result=>{
      this.departments = result;
    });
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
