package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.ILiderDao;
import co.edu.ue.entity.Lider;


@Service
public class LiderService implements ILiderService {
	
	@Autowired
	ILiderDao dao;
	
	@Override
	public List<Lider> listAllLider() {
		return dao.listLider();
	}

	
	@Override
	public Lider searchByIdLider(int id) {
		return dao.searchById(id);
	}

	@Override
	public boolean postByLider(Lider lider) {
		return dao.postLider(lider);
	}

	@Override
	public Lider updateByLider(Lider lider, int id) {
		return dao.updateLider(lider, id);
	}

	@Override
	public void deleteByIdLider(int id) {
		dao.deleteLider(id);
	}

}
