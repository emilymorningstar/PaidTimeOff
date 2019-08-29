import { Component, OnInit } from '@angular/core';
import {Request} from './request.component';
import {LoginService} from '../login/login.service';
import {DummyrequestService} from '../dummyrequest.service';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  d1: Date = new Date('2019-3-16');

  d2: Date = new Date('2019-3-18');
  id = 3;
  status = 2;
  requests: Request[] = [new Request(this.d1, this.d2 , this.id, this.status),

  ];

  constructor(private ls: LoginService, private d: DummyrequestService) {

  }

  ngOnInit() {
    if (this.d.getRequest() !=  null) {
      this.requests.push(this.d.getRequest());
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
