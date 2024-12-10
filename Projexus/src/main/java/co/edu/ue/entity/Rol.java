package co.edu.ue.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * The persistent class for the courses database table.
 * 
 */

@Entity
@Table (name="rol")
@NamedQuery(name="Rol.findAll", query="SELECT c FROM Rol c")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Rol")
    private int idRol;
    
    @NotNull
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9 ñÑüÜ.,;\"()]", message = "El campo contiene errores, verificar los datos e intente de nuevo")
	@Size(min=1, max=250)
    @Column(name = "nombre")
    private String nombre;
    
    @NotNull
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9 ñÑüÜ.,;\"()]", message = "El campo contiene errores, verificar los datos e intente de nuevo")
	@Size(min=1, max=250)
    @Column(name = "descripcion")
    private String descripcion;
    
  
    public Rol() {
    }


	public int getIdRol() {
		return idRol;
	}


	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}

    
