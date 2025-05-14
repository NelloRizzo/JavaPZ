import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import config from './api-config';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  register({ username, password }: { username: string, password: string }) {
    return this.http.post(config.registerUrl,
      { username: username, password: password, roles: ['admin'] });
  }
  login({ username, password }: { username: string, password: string }):Observable<AuthResponse> {
    return this.http.post<AuthResponse>(config.loginUrl,
      { username: username, password: password });
  }
}

export interface AuthResponse {
  token: string;
  username: string;
  roles: string[];
}
