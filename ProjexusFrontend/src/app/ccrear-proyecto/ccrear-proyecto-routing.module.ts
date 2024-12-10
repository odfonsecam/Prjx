import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearProyectosComponent } from './container/crear-proyectos/crear-proyectos.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {path: 'ccrear-proyecto', component:CrearProyectosComponent},
      {path: '**', redirectTo: 'ccrear-proyecto'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CcrearProyectoRoutingModule { }
