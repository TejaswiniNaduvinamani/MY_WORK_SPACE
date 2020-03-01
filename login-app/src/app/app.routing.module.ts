import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core';
import { LoginSucessComponent } from './login-sucess/login-sucess.component';
import { AppComponent } from './app.component';


export const routes: Routes = [
    {path: 'loginSuccess', component: LoginSucessComponent},
    {path: 'home', component: AppComponent}
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
      ],
      exports: [RouterModule]
})

export class AppRoutingModule {}
