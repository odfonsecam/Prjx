package co.edu.ue.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Lider;
import co.edu.ue.jpa.ILiderJpa;

@Repository
public class LiderDao implements ILiderDao{
	
	@Autowired
	ILiderJpa jpa;

	@Override
	public List<Lider> listLider() {
		return jpa.findAll();
	}

	@Override
	public Lider searchById(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean postLider(Lider lider) {
		if(!jpa.save(lider).equals(null)) return true;
		return false;
	}

	@Override
	public Lider updateLider(Lider lider, int id) {
		Lider newLider = jpa.findById(id).get();
		
		if (Objects.nonNull(lider.getId_usuarios())) {
			newLider.setId_usuarios(lider.getId_usuarios());
		}
		
		if (Objects.nonNull(lider.getId_proyecto())) {
			newLider.setId_proyecto(lider.getId_proyecto());
		}
		
		if (Objects.nonNull(lider.getId_rol())) {
			newLider.setId_rol(lider.getId_rol());
		}
		
		
		return jpa.save(newLider);
	}

	@Override
	public void deleteLider(int id) {
		jpa.deleteById(id);
	}

}
