package com.project.superheroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.superheroes.model.Superhero;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

}
