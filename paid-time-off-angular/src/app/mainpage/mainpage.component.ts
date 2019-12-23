import { Component, OnInit } from '@angular/core';
import {Request} from './request.component';
import {LoginService} from '../login/login.service';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  requests: Request[] = [
  ];

  constructor(private ls: LoginService, private r: Request) {

  }

  ngOnInit() {
    if (this.r !=  null) {
      this.requests.push(this.r);
    }
  }
  // retrieveRequests(email: string) {
  // get requests from the server
    // this.requests.push();
// }

getName(n: number) {
    if (n === 2) {
      return 'pending';
    }
    if (n === 3) {
    return 'denied';
  }
    if (n === 1) {
    return 'approved';
  }
}
}
