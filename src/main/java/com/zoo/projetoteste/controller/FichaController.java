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

import com.zoo.projetoteste.model.Ficha;
import com.zoo.projetoteste.service.FichaService;

@RestController
@RequestMapping("/ficha")
public class FichaController {

	@Autowired
	FichaService service;

	@PostMapping("/criar")
	public Ficha criaFicha(@Valid @RequestBody Ficha a) {
		return service.salvar(a);

	}

	@GetMapping("/listar")
	public List<Ficha> buscarFichas() {
		return service.buscarTodos();

	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Ficha> buscarFichaPorId(@PathVariable(value = "id") Long id) {
		Ficha ficha = service.buscarFicha(id);
		return null == ficha ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(ficha);
	}

	@PutMapping("/alterar/{id}")
	public ResponseEntity<Ficha> alterarFichaPorId(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Ficha fichaDetalhes) {
		Ficha ficha = service.buscarFicha(id);
		if (null == ficha) {
			return ResponseEntity.notFound().build();
		}

		ficha.setDtcadastro(fichaDetalhes.getDtcadastro());
		ficha.setObservacao(fichaDetalhes.getObservacao());
		Ficha fichaalterada = service.salvar(ficha);
		return ResponseEntity.ok().body(fichaalterada);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Ficha> removerFichaPorId(@PathVariable(value = "id") Long id) {
		Ficha ficha = service.buscarFicha(id);
		if (null == ficha) {
			return ResponseEntity.notFound().build();
		}
		service.remover(ficha);
		return ResponseEntity.ok().build();
	}
}
