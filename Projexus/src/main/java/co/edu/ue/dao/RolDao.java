package co.edu.ue.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Rol;
import co.edu.ue.entity.Tareas;
import co.edu.ue.jpa.IRolJpa;
import co.edu.ue.jpa.ITareasJpa;

@Repository
public class RolDao implements IRolDao{
	
	@Autowired
	IRolJpa jpa;

	@Override
	public List<Rol> listRol() {
		return jpa.findAll();
	}

	@Override
	public Rol searchById(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean postRol(Rol rol) {
		if(!jpa.save(rol).equals(null)) return true;
		return false;
	}

	@Override
	public Rol updateRol(Rol rol, int id) {
		Rol newRol = jpa.findById(id).get();
		
		if (Objects.nonNull(rol.getNombre()) && Objects.nonNull(rol.getNombre())) {
		    newRol.setNombre(rol.getNombre());
		}
		
		if (Objects.nonNull(rol.getDescripcion()) && Objects.nonNull(rol.getDescripcion())) {
		    newRol.setDescripcion(rol.getDescripcion());
		}
		
		
		return jpa.save(newRol);
	}

	@Override
	public void deleteRol(int id) {
		jpa.deleteById(id);
	}

	
}
