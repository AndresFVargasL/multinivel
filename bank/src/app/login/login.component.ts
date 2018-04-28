import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Login } from '../model/login';
import { UsuarioService } from '../usuario.service';
import { Response } from '../model/Response';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  title = 'Web Bank'; 
  response: Response;
  codigo: String;
  
  @Input() loginUser: Login;

  constructor(private router: Router,
              private usuarioService: UsuarioService) { 
    this.loginUser = new Login();
  }

  ngOnInit() {
  }

  login(): void{
    this.usuarioService.authUser(this.loginUser)
    .subscribe(response => {

      this.codigo = response.codigo;
      if(this.codigo == "0"){
        this.router.navigate(['/dashboard']);
      }else{
        console.log(response.mensaje);
      }
    
    });
  }
}
