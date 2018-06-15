package com.zoo.projetoteste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.projetoteste.dao.FichaDAO;
import com.zoo.projetoteste.model.Ficha;

@Service
public class FichaService {

	@Autowired
	FichaDAO FichaDao;
	
	public Ficha salvar(Ficha f) {
		return FichaDao.save(f);
	}
	
	public List<Ficha> buscarTodos() {
		return FichaDao.findAll();
	}
	
	public Ficha buscarFicha(Long id) {
		return FichaDao.getOne(id);
	}
	
	public void remover(Ficha f) {
		FichaDao.delete(f);
	}
}
