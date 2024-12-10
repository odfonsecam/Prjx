import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../../service.service'; 

@Component({
  selector: 'app-inicio',
  standalone: false,
  
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {
  proyectos: any[] = []; // Lista de proyectos
  proyectosFiltrados: any[] = []; // Proyectos filtrados
  busqueda: string = ''; // Variable de búsqueda
  tareas: any[] = [];

  constructor(private serviceService: ServiceService) { }

  ngOnInit(): void {
    this.cargarProyectos();
    this.cargarTareas();
  }

  cargarProyectos(): void {
    this.serviceService.getProyectos().subscribe((data) => {
      this.proyectos = data ?? []; // Asegurarse de que 'data' no sea null
      this.proyectosFiltrados = data ?? []; // Lo mismo para proyectosFiltrados
    });
  }

  buscarProyecto(event: Event): void {
    const input = event.target as HTMLInputElement; // Hacer la comprobación del tipo
    this.busqueda = input?.value ?? ''; // Usar encadenamiento opcional
    if (this.busqueda) {
      this.proyectosFiltrados = this.proyectos.filter(proyecto =>
        proyecto.descripcion.toLowerCase().includes(this.busqueda.toLowerCase())
      );
    } else {
      this.proyectosFiltrados = this.proyectos; // Si no hay búsqueda, mostrar todos los proyectos
    }
  }

  cargarTareas(): void {
    this.serviceService.getTareas().subscribe({
      next: (data) => {
        this.tareas = data;
        console.log('Tareas cargadas:', this.tareas);
      },
      error: (err) => {
        console.error('Error al cargar las tareas:', err);
      }
    });
  }

}

