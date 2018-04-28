import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { CoverComponent } from './cover/cover.component';
import { ConsignarComponent } from './consignar/consignar.component';
import { RetirarComponent } from './retirar/retirar.component';

const routes: Routes = [
  { path: '', redirectTo: '/cover', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'consignar', component: ConsignarComponent },
  { path: 'retirar', component: RetirarComponent },
  { path: 'login', component: LoginComponent },
  { path: 'cover', component: CoverComponent }
]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
