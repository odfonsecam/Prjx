package co.edu.ue.entity;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * The persistent class for the courses database table.
 * 
 */

@Entity
@Table (name="asignado")
@NamedQuery(name="Asignado.findAll", query="SELECT c FROM Asignado c")
public class Asignado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Asignado")
    private int idAsignado;
    
    @ManyToOne
    @JoinColumn(name = "id_usuarios")
    private Usuarios id_usuarios;
    
    @ManyToOne
    @JoinColumn(name = "id_tareas")
    private Tareas id_tareas;
    
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol id_rol;
    
  
    public Asignado() {
    }


	public int getIdAsignado() {
		return idAsignado;
	}


	public void setIdAsignado(int idAsignado) {
		this.idAsignado = idAsignado;
	}


	public Usuarios getId_usuarios() {
		return id_usuarios;
	}


	public void setId_usuarios(Usuarios id_usuarios) {
		this.id_usuarios = id_usuarios;
	}


	public Tareas getId_tareas() {
		return id_tareas;
	}


	public void setId_tareas(Tareas id_tareas) {
		this.id_tareas = id_tareas;
	}


	public Rol getId_rol() {
		return id_rol;
	}


	public void setId_rol(Rol id_rol) {
		this.id_rol = id_rol;
	}


}

    
