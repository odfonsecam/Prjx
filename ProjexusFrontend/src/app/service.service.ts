import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private apiUrl = 'http://localhost:8080/api/Proyecto-all';
  private apiUrlTareas = 'http://localhost:8080/api/Tareas';

  constructor(private http: HttpClient) { }

  // Método para obtener todos los proyectos
  getProyectos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
  
  // Método para enviar un nuevo proyecto
  crearProyecto(proyecto: any): Observable<any> {
    return this.http.post('http://localhost:8080/api/Proyecto', proyecto); 
  }
  
  getUsuarios(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/api/Usuarios-all');
  }

  // Crear tarea
  crearTarea(tarea: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/Tareas', tarea);
  }
  
  postUsuarios(usuario: any): Observable<any> {
    return this.http.post('http://localhost:8080/api/Usuarios', usuario);
  }

  iniciarSesion(usuario: { email: string, contrasena: string }): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/login/iniciarSesion', usuario);
  }
  getTareas(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/api/Tareas-all');
  }
  getProyectoById(id: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/Proyecto-id?id=${id}`);
  }
  
  updateProyecto(proyecto: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/api/Proyecto-id?id=${proyecto.idProyecto}`, proyecto);
  }
  
  deleteProyecto(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/Proyecto-id?id=${id}`);
  }
  deleteTarea(idTarea: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/Tareas-id?id=${idTarea}`);
  }
  updateTarea(tarea: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/api/Tareas-id?id=${tarea.idTareas}`, tarea);
  }
}


