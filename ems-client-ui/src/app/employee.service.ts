import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = environment.apiUrl+'/ems/api/v1/employees';

  constructor(private http: HttpClient) { }

  async getEmployee(id: number): Promise<any> {
    return await this.http.get(`${this.baseUrl}/${id}`).toPromise();
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  async getDepartmentList(): Promise<any> {
    return await this.http.get(`${this.baseUrl}/departments`).toPromise();
  }

  async getEmployeeHistory(id: number): Promise<any> {
    return await this.http.get(`${this.baseUrl}/${id}/payments`).toPromise();
  }

  paySalary(payment: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/payments`, payment);
  }

  deletePayment(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/payments/${id}`, { responseType: 'text' });
  }

  createDepartment(department: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/departments`, department);
  }

  deleteDepartment(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/departments/${id}`, { responseType: 'text' });
  }

}
