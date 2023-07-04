import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SavingsService {
  private _currentSavings = undefined;
  apiURL = '/api/savings';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private http: HttpClient) {}

  getSavings(userId: any): Observable<any> {
    return this.http.get<any>(this.apiURL + '/' + userId, this.httpOptions);
  }

  depositSavings(savings: any): Observable<any> {
    return this.http.post<any>(this.apiURL + '/deposit', savings, this.httpOptions);
  }

  withdrawSavings(savings: any): Observable<any> {
    return this.http.post<any>(this.apiURL + '/withdraw', savings, this.httpOptions);
  }

  public get currentSavings() {
    return this._currentSavings;
  }
  public set currentSavings(value) {
    this._currentSavings = value;
  }
}
