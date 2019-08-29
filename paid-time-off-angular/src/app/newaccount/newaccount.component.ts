import { Component, OnInit } from '@angular/core';
import {LoginService} from '../login/login.service';

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
  constructor(private ls: LoginService) { }

  ngOnInit() {
  }

  createAccount() {
// send the new account to the data base
  }

  onSubmit($event: any) {
    this.fname = $event.target.firstname.value;
    this.lname = $event.target.lastname.value;
    this.email = $event.target.email.value;
    this.password = $event.target.password.value;
    this.createAccount();

  }
}
