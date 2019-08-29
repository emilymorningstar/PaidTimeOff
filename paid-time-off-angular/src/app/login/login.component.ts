import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {LoginService} from './login.service';
// import { HttpModule } from '@angular/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 out: EventEmitter<number> = new EventEmitter();

  private username: string;
  private password: string;
  constructor(private ls: LoginService) {
    this.ls.setVariables(null, null, null);
  }

  ngOnInit() {
  }

  onSubmit($event: any) {

    this.username = $event.target.username.value;
    this.password = $event.target.password.value;
    console.log(this.username + this.password);
    //TODO remove before release
// call to the data base to check log in
    // set the variables
    if (this.password === 'admin') {
    this.ls.setVariables(this.username, 1 , 1);
    } else {
      this.ls.setVariables(this.username, 2 , 1);
    }
    // TODO status requires responce form database
    // TODO id requires responce form database

  }
  onLogout() {
  this.ls.setVariables(null, null, null);
  console.log('logout successful');
  }
}
