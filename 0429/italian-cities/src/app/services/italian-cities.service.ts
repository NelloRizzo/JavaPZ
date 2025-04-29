import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { City, Province, ResponseArray } from './models';

const apiConfig = {
  baseUrl: '/api',//'http://localhost:8080/api',
  endpoints: {
    cities: '/cities',
    provinces: '/cities/provinces',
    cityByProvince: (province: string) => `/cities/by-prov/${province}`,
  }
}

@Injectable({
  providedIn: 'root'
})
export class ItalianCitiesService {

  constructor(private http: HttpClient) { }

  getProvinces(): Observable<ResponseArray<Province>> {
    return this.http
      .get<ResponseArray<Province>>(`${apiConfig.baseUrl}${apiConfig.endpoints.provinces}`)
  }
  getcitiesByProvince(acronym: string): Observable<ResponseArray<City>> {
    return this.http
      .get<ResponseArray<City>>(`${apiConfig.baseUrl}${apiConfig.endpoints.cityByProvince(acronym)}`)
  }
}
