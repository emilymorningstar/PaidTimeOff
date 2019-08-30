import {Injectable} from '@angular/core';
import {Request} from './mainpage/request.component';

@Injectable({
  providedIn: 'root'
})
export class DummyrequestService {
  static r: Request;
  getRequest() {
    return DummyrequestService.r;
  }
  setRequest(r: Request) {
DummyrequestService.r = r;
  }

}
