package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Proyecto;

public interface IProyectoDao {
	
	List<Proyecto> listProyecto();
	Proyecto searchById(int id);
	boolean postProyecto(Proyecto proyecto);
	Proyecto updateProyecto(Proyecto proyecto, int id);
	void deleteProyecto(int id);

}
