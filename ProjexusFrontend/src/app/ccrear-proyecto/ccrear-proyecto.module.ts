import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CcrearProyectoRoutingModule } from './ccrear-proyecto-routing.module';
import { CrearProyectosComponent } from './container/crear-proyectos/crear-proyectos.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    CrearProyectosComponent
  ],
  imports: [
    CommonModule,
    CcrearProyectoRoutingModule,
    FormsModule,
  ],
  exports: [
    CrearProyectosComponent, 
  ]
})
export class CcrearProyectoModule { }
