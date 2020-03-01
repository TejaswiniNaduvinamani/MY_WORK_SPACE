import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import {Injectable} from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable()
export class LoginService {

    constructor(private http: HttpClient) {}

    public getAuthorization(user: string, password: string): Observable<any> {
        let params = new HttpParams();
        // let header = new HttpHeaders({'Access-Control-Allow-Origin': 'http://localhost:4200'});
        params = params.set('user', user);
        params = params.set('password', password);
        return this.http.get('http://localhost:8080/rest/login', {params: params});
    }
}
