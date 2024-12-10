import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../../service.service';  // Asegúrate de que el servicio esté correctamente importado
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-tareas',
  standalone: false,

  templateUrl: './listar-tareas.component.html',
  styleUrls: ['./listar-tareas.component.css']
})
export class ListarTareasComponent implements OnInit {
  tareas: any[] = [];

  constructor(private serviceService: ServiceService, private router: Router) {}

  ngOnInit(): void {
    this.cargarTareas();
  }

  cargarTareas(): void {
    this.serviceService.getTareas().subscribe({
      next: (data) => {
        this.tareas = data;
        this.tareas.forEach(tarea => tarea.isEditing = false);
        console.log('Tareas cargadas:', this.tareas);
      },
      error: (err) => {
        console.error('Error al cargar las tareas:', err);
      }
    });
  }
  editarTarea(tarea: any): void {
    tarea.isEditing = true;
  }

  guardarTarea(tarea: any): void {
    this.serviceService.updateTarea(tarea).subscribe({
      next: () => {
        tarea.isEditing = false;  // Desactivar la edición
        this.cargarTareas();  // Recargar las tareas
        alert("Tarea actualizada correctamente");
      },
      error: (err) => {
        console.error('Error al actualizar la tarea', err);
        alert("Error al actualizar la tarea");
      }
    });
  }

  cancelarEdicion(tarea: any): void {
    tarea.isEditing = false;
    this.cargarTareas();  // Recargar las tareas para restaurar los datos originales
  }

  deleteTarea(idTarea: number): void {
    this.serviceService.deleteTarea(idTarea).subscribe(
      (response) => {
        console.log(response.message);  
        alert("Tarea eliminada correctamente");
       
      },
      (error) => {

        console.error('Error al eliminar la tarea:', error);
        alert('Hubo un problema al eliminar la tarea.');
      }
    );
  }
}

