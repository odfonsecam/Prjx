package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Asignado;

public interface IAsignadoDao {
	
	List<Asignado> listAsignado();
	Asignado searchById(int id);
	boolean postAsignado(Asignado asignado);
	Asignado updateAsignado(Asignado asignado, int id);
	void deleteAsignado(int id);

}
