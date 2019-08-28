import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  static email: string;
  static status: number;
  static id: number;

  setVariables(email: string, status: number, id: number) {
    LoginService.email = email;
    LoginService.status = status;
    LoginService.id = id;
  }
  constructor() { }

  getid() {
    return LoginService.id;
  }

  getStatus() {
    return LoginService.status;
  }
  getEmail() {
    return LoginService.email;
  }
}
