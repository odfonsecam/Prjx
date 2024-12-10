import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListarProyectoRoutingModule } from './listar-proyecto-routing.module';
import { ListarProyectoComponent } from './container/listar-proyecto/listar-proyecto.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ListarProyectoComponent
  ],
  imports: [
    CommonModule,
    ListarProyectoRoutingModule,
    FormsModule,
  ],
  exports: [
    ListarProyectoComponent, 
  ]
})
export class ListarProyectoModule { }
