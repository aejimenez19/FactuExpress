import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  private apiUrl = 'http://localhost:8082/v1';

  postRegister(dato: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/company/register`, dato)
  }

  postlogin(dato: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/auth/login`, dato)
  }

  enviardInvoice(invoice: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/bill/create`, invoice)
  }
}
