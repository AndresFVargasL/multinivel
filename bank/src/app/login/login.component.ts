import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Login } from '../model/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  title = 'Web Bank'; 
  
  @Input() loginUser: Login;

  constructor(private router: Router) { 
    this.loginUser = new Login();
  }

  ngOnInit() {
  }

  login(): void{

    if(this.loginUser.user == "admin" && this.loginUser.password == "123456"){
      this.router.navigate(['/dashboard']);
    }else{
      console.log("Usuario incorrecto");
    }
  }

}
