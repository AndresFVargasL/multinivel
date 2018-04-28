import { Component, OnInit, Input } from '@angular/core';

import { UsuarioService } from '../usuario.service';
import { TransaccionService } from '../transaccion.service';
import { Router, ActivatedRoute } from '@angular/router';
/*
- feather-icons is a directory installed in node_modules.
- I dont have to specify the whole path like '../node_modules/path/to/feather-icons'.
- Also rememeber to call the feather.replace() inside ngOnInit
- because it needs to first make sure the component loads first
- Source: https://stackoverflow.com/questions/44995317/how-to-use-svg-icon-set-package-from-node-modules-in-angular4?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
*/
import * as feather from 'feather-icons';
import { Transaccion } from '../model/Transaccion';

@Component({
  selector: 'app-consignar',
  templateUrl: './consignar.component.html',
  styleUrls: ['./consignar.component.css']
})
export class ConsignarComponent implements OnInit {

  user: string;
  codigo: string;
  mensaje: string;
  @Input() transaccion: Transaccion;


  constructor(private router: Router,
    private usuarioService: UsuarioService,
    private transaccionService: TransaccionService) {
      this.transaccion = new Transaccion();
      this.mensaje = "";
    if(usuarioService.userInSession == null){
      this.router.navigate(['/']);
    }else{
      this.user = 'Bienvenido, ' + usuarioService.userInSession;
      this.transaccion.usuario = usuarioService.codigo;
      this.transaccion.tipoTransaccion = 2;
    }
  }

  ngOnInit() {
    feather.replace();
  }

  consignar(): void {
    this.transaccionService.consignar(this.transaccion)
    .subscribe(response => {
      this.codigo = response.codigo;
      this.mensaje = response.mensaje;
      if(this.codigo == "0"){
        this.limpiar();
      }
    });
  }

  limpiar(): void {
    this.transaccion.valor = 0;
    this.transaccion.cuenta = "";
    this.transaccion.cedula = 0;
    this.mensaje = "";
  }

}
