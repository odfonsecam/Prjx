import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CproyectosRoutingModule } from './cproyectos-routing.module';
import { ProyectosComponent } from './container/proyectos/proyectos.component';


@NgModule({
  declarations: [
    ProyectosComponent
  ],
  imports: [
    CommonModule,
    CproyectosRoutingModule
  ]
})
export class CproyectosModule { }
