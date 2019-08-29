import { Component, OnInit } from '@angular/core';
import {Request} from './request.component';
import {LoginService} from '../login/login.service';

@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent implements OnInit {
  requests: Request[] = [ new Request(0, 0, 'Emily', 'Morningstar', 'emorningstar@riis.com', 3)];
  constructor(private ls: LoginService) { }

  ngOnInit() {
  }
  retrieveRequests() {
    // get requests from the server
  }

  approve($event) {
    console.log('submit');
    console.log(this.requests);
// change event on database
    this.requests.splice(0, 1);
    console.log(this.requests);
  }
}
