import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { ServiceService } from '../../../service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: false,
  
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email: string = '';
  contrasena: string = '';
  errorMessage: string = '';

  constructor(private serviceService: ServiceService, private router: Router) {}

  iniciarSesion() {
    const usuario = {
      email: this.email,
      contrasena: this.contrasena
    };

    this.serviceService.iniciarSesion(usuario).subscribe(
      (response) => {
        if (response) {
          this.router.navigate(['/cinicio']);  
        } else {
          this.errorMessage = 'Email o contraseña incorrectos.';
        }
      },
      (error) => {
        this.errorMessage = 'Error de conexión al servidor.';
      }
    );
  }
}
