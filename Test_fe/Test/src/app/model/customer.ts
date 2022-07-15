import {Type} from "./type";

export interface Customer {
  customerId: number;
  customerName: string;
  dateOfBirth: string;
  phone:string;
  email: string;
  type: Type;
}
