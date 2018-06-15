package com.zoo.projetoteste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.projetoteste.dao.AnimalDAO;
import com.zoo.projetoteste.model.Animal;

@Service
public class AnimalService {
	
	@Autowired
	AnimalDAO animalDao;
	
	public Animal salvar(Animal f) {
		return animalDao.save(f);
	}
	
	public List<Animal> buscarTodos() {
		return animalDao.findAll();
	}
	
	public Animal buscarAnimal(Long id) {
		return animalDao.getOne(id);
	}
	
	public void remover(Animal f) {
		animalDao.delete(f);
	}
}
