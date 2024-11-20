import { HttpClient, HttpParams  } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { usuario } from '../Models/model';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  private apiUrl = 'http://localhost:8080';

  getCompanyWhitIdBill(id:any): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/company/${id}`)
  }

  getTotalItems(id:any): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/item/total/${id}`)
  }

  getItemsWhitIdBill(id:any): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/item/${id}`)
  }
  getInfoUser(id:any): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/usuario/${id}`)
  }

  getUserForEmail(email:any): Observable<any> {
    const params = new HttpParams().set('email', email);
    return this.http.get<any>(`${this.apiUrl}/customer`, {params})
  }

  getAhorro(id:any): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/usuario/ahorro/${id}`)
  }


  postUsuario(usuario:usuario): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/customer`, usuario)
  }

  getFacturas(id:any, fecha:any): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/bill/${id}/${fecha}`)
  }

  getNumeroFacturas(id:any): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/factura/${id}`)
  }
}
