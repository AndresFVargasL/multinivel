import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Response } from './model/Response';
import { Login } from './model/login';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable()
export class UsuarioService {

  private urlAuth: string;
  public userInSession: string;
  public codigo: string;

  constructor(private http: HttpClient) { 
    this.urlAuth = 'http://10.199.203.138:8080/web-bank/rest/controllers/usuario/autenticar';
  }

  /** Log a message in console */
  private log(message: string) {
    console.log('### Servicios de Usuarios: ' + message+ '###');
  }

  authUser (loginUser: Login): Observable<Response> {
    let usuario:String  = loginUser.user;
    let clave:String  = loginUser.password;

    if(usuario == ""){
      usuario = "%20";
    }

    if(clave == ""){
      clave = "%20";
    }

    const url = `${this.urlAuth}/${usuario}/${clave}`;
    return this.http.get<Response>(url)
    .pipe(
      tap(usuario => {
        this.userInSession = usuario.nombre;
        this.codigo = usuario.usuario;
      }),
      catchError(this.handleError<Response>(`Error de comunicación con el web service al tratar de autenticar al usuario : ${loginUser.user}`))
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
