package com.zoo.projetoteste.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.projetoteste.model.Ficha;

public interface FichaDAO extends JpaRepository<Ficha, Long> {

}
