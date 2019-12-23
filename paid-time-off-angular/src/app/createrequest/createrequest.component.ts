import {Component, EventEmitter, OnInit} from '@angular/core';
import {LoginService} from '../login/login.service';
import {Request} from '../mainpage/request.component';

@Component({
  selector: 'app-createrequest',
  templateUrl: './createrequest.component.html',
  styleUrls: ['./createrequest.component.css']
})
export class CreaterequestComponent implements OnInit {
  constructor(private ls: LoginService, private r: Request) { }

  ngOnInit() {
  }

  onSubmitRequest($event: any) {
    console.log($event.target.sdate.value);
    let d1 = new Date($event.target.sdate.value);
    let d2 = new Date($event.target.edate.value);
    const r = new Request(d1, d2, this.ls.getid() , 2);  // $event.target.username.value;
   // this.d.setRequest(r);//needs to set a real request
  }
}
