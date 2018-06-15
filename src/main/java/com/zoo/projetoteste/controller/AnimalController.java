package com.zoo.projetoteste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.projetoteste.model.Animal;
import com.zoo.projetoteste.service.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	AnimalService service;

	@PostMapping("/criar")
	public Animal criaAnimal(@Valid @RequestBody Animal a) {
		return service.salvar(a);

	}

	@GetMapping("/listar")
	public List<Animal> buscarAnimais() {
		return service.buscarTodos();

	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Animal> buscarAnimalPorId(@PathVariable(value = "id") Long id) {
		Animal animal = service.buscarAnimal(id);
		return null==animal? ResponseEntity.notFound().build() : ResponseEntity.ok().body(animal);
	}
	
	@PutMapping("/alterar/{id}")
	public ResponseEntity<Animal> alterarAnimalPorId(@PathVariable(value = "id") Long id, @Valid @RequestBody Animal animalDetalhes) {
		Animal animal = service.buscarAnimal(id);
		if(null==animal) { 
			return ResponseEntity.notFound().build();
		} 
			
		animal.setNome(animalDetalhes.getNome());
		Animal animalalterado =  service.salvar(animal);
		return ResponseEntity.ok().body(animalalterado);
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Animal> removerAnimalPorId(@PathVariable(value = "id") Long id) {
		Animal animal = service.buscarAnimal(id);
		if(null==animal) { 
			return ResponseEntity.notFound().build();
		} 
		service.remover(animal);
		return ResponseEntity.ok().build();
	}
}
