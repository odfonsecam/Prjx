package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Rol;

public interface IRolDao {
	
	List<Rol> listRol();
	Rol searchById(int id);
	boolean postRol(Rol rol);
	Rol updateRol(Rol rol, int id);
	void deleteRol(int id);

}
