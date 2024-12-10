package co.edu.ue.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.sql.Date;

/**
 * The persistent class for the courses database table.
 * 
 */

@Entity
@Table (name="proyecto")
@NamedQuery(name="Proyecto.findAll", query="SELECT c FROM Proyecto c")
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Proyecto")
    private int idProyecto;

    @NotNull
    @NotEmpty
    @Column(name = "tiempo_estimado")
    private Date tiempoEstimado;

    @NotNull
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9 ñÑüÜ.,;\"()]", message = "El campo contiene errores, verificar los datos e intente de nuevo")
	@Size(min=1, max=250)
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9 ñÑüÜ.,;\"()]", message = "El campo contiene errores, verificar los datos e intente de nuevo")
	@Size(min=1, max=250)
    @Column(name = "estado")
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "lider")
    private Usuarios lider;

    public Proyecto() {
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Date getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Date tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuarios getLider() {
        return lider;
    }

    public void setLider(Usuarios lider) {
        this.lider = lider;
    }
}

