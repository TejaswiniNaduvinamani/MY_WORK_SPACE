import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule } from '@angular/common/http' ;
import { AppComponent } from './app.component';
import { LoginPopupComponent } from './login-popup/login-popup.component';
import { LoginSucessComponent } from './login-sucess/login-sucess.component';
import {LoginService} from '../app/shared/login.service';
import { AppRoutingModule } from './app.routing.module';

@NgModule({
  declarations: [
    AppComponent,
    LoginPopupComponent,
    LoginSucessComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
