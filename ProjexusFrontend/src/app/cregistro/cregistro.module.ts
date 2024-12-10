import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CregistroRoutingModule } from './cregistro-routing.module';
import { RegistroComponent } from './container/registro/registro.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    RegistroComponent
  ],
  imports: [
    CommonModule,
    CregistroRoutingModule,
    FormsModule,
  ]
})
export class CregistroModule { }
