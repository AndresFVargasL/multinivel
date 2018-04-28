import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Response } from './model/Response';
import { Transaccion } from './model/Transaccion';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class TransaccionService {

  private urlTransaccion: string;
  private componentConsignar: string;
  private componentRetirar: string;
  
  constructor(private http: HttpClient) {
    this.urlTransaccion = 'http://10.199.203.138:8080/web-bank/rest/controllers/transaccion';
    this.componentConsignar = 'consignar';
    this.componentRetirar = 'retirar';
  }

  /** Log a message in console */
  private log(message: string) {
    console.log('### Servicios de Usuarios: ' + message+ '###');
  }

  consignar (transaccion: Transaccion): Observable<Response> {
    const url = `${this.urlTransaccion}/${this.componentConsignar}`;
    return this.http.post<Response>(url, transaccion, httpOptions)
    .pipe(
      tap(transaction =>{
        if(transaction.codigo != "0"){
          console.log(transaction.mensaje);
        }
      }),
      catchError(this.handleError<Response>(`Error de comunicacion con el servicio de consigancion`))
    );
  }



  retirar (transaccion: Transaccion): Observable<Response> {

    const url = `${this.urlTransaccion}/${this.componentRetirar}`;
    return this.http.post<Response>(url, transaccion, httpOptions)
    .pipe(
      tap(transaction =>{
        if(transaction.codigo != "0"){
          console.log(transaction.mensaje);
        }
      }),
      catchError(this.handleError<Response>(`Error de comunicacion con el servicio de retiros`))
    );
  }





  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
private handleError<T> (operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {

    // TODO: send the error to remote logging infrastructure
    console.error(error); // log to console instead

    // TODO: better job of transforming error for user consumption
    this.log(`${operation} failed: ${error.message}`);

    // Let the app keep running by returning an empty result.
    return of(result as T);
  };

}
}