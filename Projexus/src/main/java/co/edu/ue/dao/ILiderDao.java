package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Lider;

public interface ILiderDao {
	
	List<Lider> listLider();
	Lider searchById(int id);
	boolean postLider(Lider lider);
	Lider updateLider(Lider lider, int id);
	void deleteLider(int id);

}
