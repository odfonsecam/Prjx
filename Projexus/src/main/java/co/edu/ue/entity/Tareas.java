package co.edu.ue.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The persistent class for the courses database table.
 * 
 */

@Entity
@Table (name="tareas")
@NamedQuery(name="Tareas.findAll", query="SELECT c FROM Tareas c")
public class Tareas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Tareas")
    private int idTareas;
    
    @Column(name = "tiempo")
    private LocalDateTime tiempo;


    @Column(name = "progreso")
    private Float progreso;
    
    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios id_usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto id_proyecto;

  
    public Tareas() {
    }


	public int getIdTareas() {
		return idTareas;
	}


	public void setIdTareas(int idTareas) {
		this.idTareas = idTareas;
	}


	public LocalDateTime getTiempo() {
		return tiempo;
	}


	public void setTiempo(LocalDateTime tiempo) {
		this.tiempo = tiempo;
	}


	public Float getProgreso() {
		return progreso;
	}


	public void setProgreso(Float progreso) {
		this.progreso = progreso;
	}


	public Usuarios getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Usuarios id_usuario) {
		this.id_usuario = id_usuario;
	}


	public Proyecto getId_proyecto() {
		return id_proyecto;
	}


	public void setId_proyecto(Proyecto id_proyecto) {
		this.id_proyecto = id_proyecto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	}

    
