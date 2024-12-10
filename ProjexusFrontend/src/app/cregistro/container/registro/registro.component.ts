import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../../service.service';

@Component({
  selector: 'app-registro',
  standalone: false,
  
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})

export class RegistroComponent implements OnInit {
  usuario: any = {
    nombreusuarios: '',
    email: '',
    contraseña: ''
  };

  constructor(private service: ServiceService) {}

  ngOnInit(): void {}

  registrarUsuario(): void {
    this.service.postUsuarios(this.usuario).subscribe({
      next: () => {
        alert('Usuario registrado exitosamente');
        this.usuario = { nombreusuarios: '', email: '', contraseña: '' }; // Limpia el formulario
      },
      error: (err) => {
        console.error(err);
        alert('Ocurrió un error al registrar el usuario');
      }
    });
  }
}
