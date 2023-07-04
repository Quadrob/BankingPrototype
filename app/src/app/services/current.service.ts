import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, retry } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CurrentService {
  private _currentAccount = undefined;
  apiURL = '/api/current';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private http: HttpClient) {}

  getCurrent(userId: any): Observable<any> {
    return this.http.get<any>(this.apiURL + '/' + userId, this.httpOptions);
  }

  depositCurrent(current: any): Observable<any> {
    return this.http.post<any>(this.apiURL + '/deposit', current, this.httpOptions);
  }

  withdrawCurrennt(current: any): Observable<any> {
    return this.http.post<any>(this.apiURL + '/withdraw', current, this.httpOptions);
  }

  public get currentAccount() {
    return this._currentAccount;
  }
  public set currentAccount(value) {
    this._currentAccount = value;
  }
}
