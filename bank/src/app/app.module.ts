import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { HttpClientModule } from '@angular/common/http'; // <-- Http requests lives here
import { NgxMaskModule } from 'ngx-mask';
import { CurrencyMaskModule } from "ngx-currency-mask";

import { AppRoutingModule } from './/app-routing.module';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { CoverComponent } from './cover/cover.component';
import { ConsignarComponent } from './consignar/consignar.component';
import { UsuarioService } from './usuario.service';
import { TransaccionService } from './transaccion.service';
import { RetirarComponent } from './retirar/retirar.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    CoverComponent,
    ConsignarComponent,
    RetirarComponent
  ],
  imports: [
    BrowserModule,
    CurrencyMaskModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgxMaskModule.forRoot()
  ],
  providers: [UsuarioService, TransaccionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
