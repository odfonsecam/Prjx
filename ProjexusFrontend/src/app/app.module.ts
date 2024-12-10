import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { CheaderComponent } from './cheader/cheader.component';
import { CfooterComponent } from './cfooter/cfooter.component';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http'; // Nueva forma de manejar HttpClient
import { CcrearProyectoModule } from './ccrear-proyecto/ccrear-proyecto.module';
import { CcrearTareasModule } from './ccrear-tareas/ccrear-tareas.module';
import { CregistroModule } from './cregistro/cregistro.module';
import { ListarTareasModule } from './listar-tareas/listar-tareas.module';
import { ListarProyectoModule } from './listar-proyecto/listar-proyecto.module';


@NgModule({
  declarations: [
    AppComponent,
    CheaderComponent,
    CfooterComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule, 
    AppRoutingModule,
    CcrearProyectoModule,
    CcrearTareasModule,
    ReactiveFormsModule,
    CregistroModule,
    ListarTareasModule,
    ListarProyectoModule,
    HttpClientModule
  ],
  providers: [provideHttpClient(withInterceptorsFromDi())],

  bootstrap: [AppComponent]
})
export class AppModule { }
