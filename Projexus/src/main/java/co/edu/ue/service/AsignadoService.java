package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IAsignadoDao;
import co.edu.ue.entity.Asignado;



@Service
public class AsignadoService implements IAsignadoService {
	
	@Autowired
	IAsignadoDao dao;
	
	@Override
	public List<Asignado> listAllAsignado() {
		return dao.listAsignado();
	}

	
	@Override
	public Asignado searchByIdAsignado(int id) {
		return dao.searchById(id);
	}

	@Override
	public boolean postByAsignado(Asignado asignado) {
		return dao.postAsignado(asignado);
	}

	@Override
	public Asignado updateByAsignado(Asignado asignado, int id) {
		return dao.updateAsignado(asignado, id);
	}

	@Override
	public void deleteByIdAsignado(int id) {
		dao.deleteAsignado(id);
	}
	
}
