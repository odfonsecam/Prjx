package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Lider;

public interface ILiderService {
	List<Lider> listAllLider();
	Lider searchByIdLider(int id);
	boolean postByLider(Lider lider);
	Lider updateByLider(Lider lider, int id);
	void deleteByIdLider(int id);

}
