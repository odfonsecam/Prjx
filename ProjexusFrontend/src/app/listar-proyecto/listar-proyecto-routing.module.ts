import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarProyectoComponent } from './container/listar-proyecto/listar-proyecto.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {path: 'listar-proyecto', component:ListarProyectoComponent},
      {path: '**', redirectTo: 'cproyectos'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListarProyectoRoutingModule { }
