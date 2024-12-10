import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarTareasComponent } from './container/listar-tareas/listar-tareas.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {path: 'listar-tareas', component:ListarTareasComponent},
      {path: '**', redirectTo: 'listar-tareas'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListarTareasRoutingModule { }
