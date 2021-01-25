import { Employee } from "./employee";

export class Payment {
  payId: number;
  dayOfPayment: string;
  monthOfPayment: string;
  yearOfPayment: string;
  amount: number;
  employee: Employee;
}