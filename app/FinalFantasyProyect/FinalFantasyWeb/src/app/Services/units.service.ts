import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


import { Units } from '../Models/units';

@Injectable({
  providedIn: 'root'
})
export class UnitsService {
  units: Units[];
  readonly URL_API = "http://localhost:7001/FinalFantasy/api/units";
  constructor(private http: HttpClient) { }

  getUnits(): Observable<Units[]> {
    return this.http.get<Units[]>(this.URL_API).pipe(catchError(this.errorHandler));
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

  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }

}
