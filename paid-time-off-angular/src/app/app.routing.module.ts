import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NewaccountComponent} from './newaccount/newaccount.component';
import {MainpageComponent} from './mainpage/mainpage.component';
import {CreaterequestComponent} from './createrequest/createrequest.component';
import {AdminpageComponent} from './adminpage/adminpage.component';
import {HolidaysComponent} from './holidays/holidays.component';


const appRoutes: Routes = [
  {path: 'myrequests', component: MainpageComponent},
  {path: 'newrequest', component: CreaterequestComponent},
  {path: 'createaccount', component: NewaccountComponent},
  {path: 'approverequest', component: AdminpageComponent},
  {path: 'holidays', component: HolidaysComponent},
  {path: 'main', component: MainpageComponent},
  {path: '', component: MainpageComponent }
];
@NgModule({
  imports: [RouterModule, RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
