import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CcrearTareasRoutingModule } from './ccrear-tareas-routing.module';
import { CrearTareasComponent } from './container/crear-tareas/crear-tareas.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    CrearTareasComponent
  ],
  imports: [
    CommonModule,
    CcrearTareasRoutingModule,
    FormsModule,
  ],
  exports: [
    CrearTareasComponent, 
  ]
})
export class CcrearTareasModule { }
