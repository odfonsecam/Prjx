import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './container/login/login.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {path: 'clogin', component:LoginComponent},
      {path: '**', redirectTo: 'clogin'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CloginRoutingModule { }
