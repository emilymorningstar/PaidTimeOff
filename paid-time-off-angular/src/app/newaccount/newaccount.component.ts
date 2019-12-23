import { Component, OnInit } from '@angular/core';
import {LoginService} from '../login/login.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-newaccount',
  templateUrl: './newaccount.component.html',
  styleUrls: ['./newaccount.component.css']
})
export class NewaccountComponent implements OnInit {
fname: string;
lname: string;
email: string;
password: string;
  constructor(private ls: LoginService, private http: HttpClient) { }

  ngOnInit() {
  }

  createAccount(fname: string, lname: string, email: string, password: string) {
    return this.http.post('http://localhost:8080/Employees', {'Firstname':fname ,'Lastname':lname,'email':email,'Password':password});
  }

  onSubmit($event: any) {
    this.fname = $event.target.firstname.value;
    this.lname = $event.target.lastname.value;
    this.email = $event.target.email.value;
    this.password = $event.target.password.value;
    this.createAccount(this.fname,this.lname,this.email,this.password);

  }
}
