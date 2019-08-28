import { Component, OnInit } from '@angular/core';
import {Request} from './request.component';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  requests: Request[] = [];

  constructor() {
  }

  ngOnInit() {

  }
  retrieveRequests(email: string) {
  // get requests from the server
    this.requests.push(new Request());
}
}
