import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',  
    redirectTo: '/clogin', 
    pathMatch: 'full'
  },
  {
    path: 'cinicio', loadChildren: ()=> import('./cinicio/cinicio.module').then((m)=>m.CinicioModule),
  },
  {
    path: 'clogin', loadChildren: ()=> import('./clogin/clogin.module').then((m)=>m.CloginModule)
  },
  {
    path: 'cregistro', loadChildren: ()=> import('./cregistro/cregistro.module').then((m)=>m.CregistroModule)
  },
  {
    path: 'cproyectos', loadChildren: ()=> import('./cproyectos/cproyectos.module').then((m)=>m.CproyectosModule),
  },
  {
    path: 'ccrear-proyecto', loadChildren: ()=> import('./ccrear-proyecto/ccrear-proyecto.module').then((m)=>m.CcrearProyectoModule)
  },
  {
    path: 'ccrear-tareas', loadChildren: ()=> import('./ccrear-tareas/ccrear-tareas.module').then((m)=>m.CcrearTareasModule)
  },
  { 
    path: ' cregistro ', loadChildren: ()=> import('./cregistro/cregistro.module').then((m)=>m.CregistroModule)
  },
  {
    path: 'login ', loadChildren: ()=> import('./clogin/clogin-routing.module').then((m)=>m.CloginRoutingModule)
  },
  { 
   path: 'listar-tareas', loadChildren: ()=> import('./listar-tareas/listar-tareas-routing.module').then((m)=>m.ListarTareasRoutingModule),
  },
  {
    path: 'listar-proyecto', loadChildren: ()=> import('./listar-proyecto/listar-proyecto-routing.module').then((m)=>m.ListarProyectoRoutingModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
