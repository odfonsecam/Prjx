import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../../service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-proyectos',
  standalone: false,

  templateUrl: './crear-proyectos.component.html',
  styleUrls: ['./crear-proyectos.component.css']
})
export class CrearProyectosComponent implements OnInit {
  usuarios: any[] = [];
  proyecto = {
    tiempoEstimado: '',
    descripcion: '',
    estado: '',
    lider: ''
  };

  constructor(private service: ServiceService, private router: Router) {}

  ngOnInit(): void {
    this.cargarUsuarios();
  }

  cargarUsuarios(): void {
    this.service.getUsuarios().subscribe({
      next: (data) => {
        this.usuarios = data;
        console.log('Usuarios cargados:', this.usuarios);
      },
      error: (err) => {
        console.error('Error al cargar los usuarios:', err);
      }
    });
  }

  guardarProyecto(): void {
    // Validar líder seleccionado
    const liderSeleccionado = this.usuarios.find(usuario => usuario.idUsuarios == this.proyecto.lider);
    if (!liderSeleccionado) {
      alert('Seleccione un líder válido');
      return;
    }

    // Formatear datos para el backend
    const proyectoData = {
      tiempoEstimado: this.proyecto.tiempoEstimado,
      descripcion: this.proyecto.descripcion,
      estado: this.proyecto.estado,
      lider: { idUsuarios: this.proyecto.lider } 
    };

    // Enviar datos al backend
    this.service.crearProyecto(proyectoData).subscribe({
      next: () => {
        alert('Proyecto creado exitosamente');
        this.router.navigate(['/proyectos']); // Redirige a la lista de proyectos
      },
      error: (err) => {
        console.error('Error al guardar el proyecto:', err);
        alert('Hubo un error al crear el proyecto');
      }
    });
  }
}

