import { Component, OnInit } from '@angular/core';
import {Request} from './request.component';
import {LoginService} from '../login/login.service';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  requests: Request[] = [];

  constructor(private ls: LoginService) {
  }

  ngOnInit() {

  }
  retrieveRequests(email: string) {
  // get requests from the server
    this.requests.push(new Request());
}
}
