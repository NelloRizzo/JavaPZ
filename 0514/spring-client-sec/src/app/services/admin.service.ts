import { Injectable } from '@angular/core';
import config from './api-config';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  getAdminData(): Observable<string[]> {
    return this.http.get<string[]>(config.adminUrl, {
      headers:{
        'Authorization': 'Bearer ' + localStorage.getItem('token')
      }
    });
  }
}
