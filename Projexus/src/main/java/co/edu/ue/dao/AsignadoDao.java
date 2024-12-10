package co.edu.ue.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Asignado;
import co.edu.ue.jpa.IAsignadoJpa;

@Repository
public class AsignadoDao implements IAsignadoDao{
	
	@Autowired
	IAsignadoJpa jpa;

	@Override
	public List<Asignado> listAsignado() {
		return jpa.findAll();
	}

	@Override
	public Asignado searchById(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean postAsignado(Asignado asignado) {
		if(!jpa.save(asignado).equals(null)) return true;
		return false;
	}

	@Override
	public Asignado updateAsignado(Asignado asignado, int id) {
		Asignado newAsignado = jpa.findById(id).get();
		
		if (Objects.nonNull(asignado.getId_usuarios())) {
			newAsignado.setId_usuarios(asignado.getId_usuarios());
		}
		
		if (Objects.nonNull(asignado.getId_tareas())) {
			newAsignado.setId_tareas(asignado.getId_tareas());
		}
		
		if (Objects.nonNull(asignado.getId_rol())) {
			newAsignado.setId_rol(asignado.getId_rol());
		}
		
		
		return jpa.save(newAsignado);
	}

	@Override
	public void deleteAsignado(int id) {
		jpa.deleteById(id);
	}

}
