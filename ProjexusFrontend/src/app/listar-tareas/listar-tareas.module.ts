
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListarTareasRoutingModule } from './listar-tareas-routing.module';
import { ListarTareasComponent } from './container/listar-tareas/listar-tareas.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ListarTareasComponent
  ],
  imports: [
    CommonModule,
    ListarTareasRoutingModule,
    FormsModule,
  ],
  exports: [
    ListarTareasComponent, 
  ]
})
export class ListarTareasModule { }