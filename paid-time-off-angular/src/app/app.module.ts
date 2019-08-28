import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import {FormsModule} from '@angular/forms';
import { AdminpageComponent} from './adminpage/adminpage.component';
import { NewaccountComponent } from './newaccount/newaccount.component';
import { CreaterequestComponent } from './createrequest/createrequest.component';
import {AppRoutingModule} from './app.routing.module';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainpageComponent,
    AdminpageComponent,
    NewaccountComponent,
    CreaterequestComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
