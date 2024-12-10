package co.edu.ue.entity;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the courses database table.
 * 
 */

@Entity
@Table (name="lider")
@NamedQuery(name="Lider.findAll", query="SELECT c FROM Lider c")
public class Lider implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Lider")
    private int idLider;
    
    
    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto id_proyecto;
    
    @ManyToOne
    @JoinColumn(name = "id_usuarios")
    private Usuarios id_usuarios;
    
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Proyecto id_rol;

  
    public Lider() {
    }


	public int getIdLider() {
		return idLider;
	}


	public void setIdTareas(int idTareas) {
		this.idLider = idTareas;
	}


	public Proyecto getId_proyecto() {
		return id_proyecto;
	}


	public void setId_proyecto(Proyecto id_proyecto) {
		this.id_proyecto = id_proyecto;
	}


	public Usuarios getId_usuarios() {
		return id_usuarios;
	}


	public void setId_usuarios(Usuarios id_usuario) {
		this.id_usuarios = id_usuario;
	}


	public Proyecto getId_rol() {
		return id_rol;
	}


	public void setId_rol(Proyecto id_rol) {
		this.id_rol = id_rol;
	}

	}

    
