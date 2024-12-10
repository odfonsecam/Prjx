import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistroComponent } from './container/registro/registro.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {path: 'cregistro', component:RegistroComponent},
      {path: '**', redirectTo: 'cregistro'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CregistroRoutingModule { }
