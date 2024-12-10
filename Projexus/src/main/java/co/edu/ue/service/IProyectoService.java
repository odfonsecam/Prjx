package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Proyecto;

public interface IProyectoService {
	List<Proyecto> listAllProyecto();
	Proyecto searchByIdProyecto(int id);
	boolean postByProyecto(Proyecto proyecto);
	Proyecto updateByProyecto(Proyecto proyecto, int id);
	void deleteByIdProyecto(int id);

}
