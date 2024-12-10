import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearTareasComponent } from './container/crear-tareas/crear-tareas.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {path: 'ccrear-tareas', component:CrearTareasComponent},
      {path: '**', redirectTo: 'ccrear-tareas'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CcrearTareasRoutingModule { }
