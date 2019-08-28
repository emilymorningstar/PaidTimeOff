import { Component, OnInit } from '@angular/core';

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
  constructor() { }

  ngOnInit() {
  }

  createAccount() {
// send the new account to the data base
  }
}
