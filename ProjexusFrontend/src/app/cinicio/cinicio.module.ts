import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CinicioRoutingModule } from './cinicio-routing.module';
import { InicioComponent } from './container/inicio/inicio.component';


@NgModule({
  declarations: [
    InicioComponent
  ],
  imports: [
    CommonModule,
    CinicioRoutingModule
  ]
})
export class CinicioModule { }
