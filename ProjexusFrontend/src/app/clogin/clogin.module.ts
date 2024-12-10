import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CloginRoutingModule } from './clogin-routing.module';
import { LoginComponent } from './container/login/login.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    CommonModule,
    CloginRoutingModule,
    FormsModule
  ]
})
export class CloginModule { }
