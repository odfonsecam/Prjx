import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './container/inicio/inicio.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {path: 'cinicio', component:InicioComponent},
      {path: '**', redirectTo: 'cinicio'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CinicioRoutingModule { }
