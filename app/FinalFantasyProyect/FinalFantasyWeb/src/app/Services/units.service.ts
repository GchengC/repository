import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Units } from '../Models/units';

@Injectable({
  providedIn: 'root'
})
export class UnitsService {
  units: Units[];
readonly URL_API = "http://localhost:7001/FinalFantasy/api/units";
  constructor(private http: HttpClient) { }

  getUnits() {
    return this.http.get<Units[]>(this.URL_API);
  }

  postUnits(unit: Units) {
    console.log(unit);
    return this.http.post(this.URL_API, unit);
  }

  putUnits(unit: Units) {
    return this.http.put(this.URL_API + `/${unit.id}`, unit);
  }

  deleteUnits(id: number) {
    return this.http.delete(this.URL_API + `/${id}`);
  }
}
