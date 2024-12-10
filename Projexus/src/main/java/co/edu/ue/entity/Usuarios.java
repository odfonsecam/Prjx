package co.edu.ue.entity;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the courses database table.
 * 
 */

@Entity
@Table (name="usuarios")
@NamedQuery(name="Usuarios.findAll", query="SELECT c FROM Usuarios c")
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Usuarios")
    private int idUsuarios;

    @Column(name = "contraseña")
    private String contrasena;

    @Column(name = "email")
    private String email;

    @Column(name = "nombre_de_usuario")
    private String nombreusuarios;

  
    public Usuarios() {
    }


	public int getIdUsuarios() {
		return idUsuarios;
	}


	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}


	public String getcontrasena() {
		return contrasena;
	}


	public void setcontrasena(String contraseña) {
		this.contrasena = contraseña;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNombreusuarios() {
		return nombreusuarios;
	}


	public void setNombreusuarios(String nombreusuarios) {
		this.nombreusuarios = nombreusuarios;
	}

    
}