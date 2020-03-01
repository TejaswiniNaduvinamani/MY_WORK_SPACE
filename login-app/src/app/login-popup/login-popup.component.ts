import { Component, OnInit, Output } from '@angular/core';
import {LoginService} from '../shared/login.service';

@Component({
  selector: 'app-login-popup',
  templateUrl: './login-popup.component.html',
  styleUrls: ['./login-popup.component.css']
})
export class LoginPopupComponent implements OnInit {

  @Output() user: string;
  login = false;
  loginSuccess = false;
  errFlag = false;
  errorMsg: string;

  constructor(private _loginService: LoginService) { }

  ngOnInit() {
  }

  onLogin(user, pwd) {
    console.log('user name : ' + user);
    console.log('password : ' + pwd);
    this.user = user;
    this._loginService.getAuthorization(user, pwd).subscribe(res => {
      console.log('res: ' + res.login);
      if (res != undefined && res.login == true) {
        this.loginSuccess = true;
      } else {
        this.loginSuccess = false;
        this.errFlag = true;
        this.errorMsg = 'Please enter valid user name and password';
      }
    });
    sessionStorage.setItem('loginSuccess',  JSON.stringify(this.loginSuccess));
  }

}
