import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProyectosComponent } from './container/proyectos/proyectos.component'; 

const routes: Routes = [

  {
    path: '',
    children: [
      {path: 'cproyectos', component:ProyectosComponent},
      {path: '**', redirectTo: 'cproyectos'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CproyectosRoutingModule { }
