package com.zoo.projetoteste.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.projetoteste.model.Animal;

public interface AnimalDAO extends JpaRepository<Animal,Long> {

}
