import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, retry } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private _currentUser = undefined;
  apiURL = '/api/user'

  httpOptions = {
	headers: new HttpHeaders({
	  'Content-Type': 'application/json',
	}),
  };

  constructor(private http: HttpClient) { }

  getUser(user: any): Observable<any> {
    return this.http.post<any>(this.apiURL + '/login', user, this.httpOptions);
  }

  createUse(user: any): Observable<any> {
    return this.http.post<any>(this.apiURL + '/create', user, this.httpOptions);
  }

  public get currentUser() {
    return this._currentUser;
  }

  public set currentUser(value) {
    this._currentUser = value;
  }
}
