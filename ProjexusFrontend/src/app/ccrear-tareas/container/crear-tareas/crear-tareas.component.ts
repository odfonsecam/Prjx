import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../../service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-tareas',
  standalone: false, 

  templateUrl: './crear-tareas.component.html',
  styleUrls: ['./crear-tareas.component.css']
})
export class CrearTareasComponent implements OnInit {
  usuarios: any[] = [];
  proyectos: any[] = [];
  tarea = {
    tiempo: '',
    progreso: null,
    descripcion: '',
    id_usuario: null,
    id_proyecto: null,
  };

  constructor(private ServiceService: ServiceService, private router: Router) {}

  ngOnInit(): void {
    this.cargarUsuarios();
    this.cargarProyectos();
  }

  cargarUsuarios(): void {
    this.ServiceService.getUsuarios().subscribe({
      next: (data) => {
        this.usuarios = data;
        console.log('Usuarios cargados:', this.usuarios);
      },
      error: (err) => {
        console.error('Error al cargar los usuarios:', err);
      }
    });
  }

  cargarProyectos(): void {
    this.ServiceService.getProyectos().subscribe({
      next: (data) => {
        this.proyectos = data;
        console.log('Proyectos cargados:', this.proyectos);
      },
      error: (err) => {
        console.error('Error al cargar los proyectos:', err);
      }
    });
  }

  guardarTarea(): void {
    if (!this.tarea.id_usuario || !this.tarea.id_proyecto || !this.tarea.descripcion) {
      alert('Debe llenar todos los campos.');
      return;
    }
  
    const tareaData = {
      tiempo: this.tarea.tiempo,
      progreso: this.tarea.progreso,
      descripcion: this.tarea.descripcion, 
      id_usuario: { idUsuarios: this.tarea.id_usuario },
      id_proyecto: { idProyecto: this.tarea.id_proyecto }
    };
  
    this.ServiceService.crearTarea(tareaData).subscribe({
      next: () => {
        alert('Tarea creada exitosamente');
        this.router.navigate(['/tareas']);  
      },
      error: (err) => {
        console.error('Error al guardar la tarea:', err);
        alert('Hubo un error al crear la tarea');
      }
    });
  }
}
