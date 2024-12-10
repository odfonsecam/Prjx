import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router'; 
import { ServiceService } from '../../../service.service'; 

@Component({
  selector: 'app-proyectos',
  standalone: false,
  
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {
  proyectos: any[] = []; // Lista de proyectos
  proyectosFiltrados: any[] = []; // Proyectos filtrados
  busqueda: string = ''; // Variable de búsqueda

  constructor(private serviceService: ServiceService, private router: Router) { }

  ngOnInit(): void {
    this.cargarProyectos();
  }
  
  verDetallesProyecto(id: number): void {
    this.router.navigate([`/proyecto/${id}`]); // Navegamos a la ruta del proyecto seleccionado
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
}
