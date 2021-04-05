package com.project.superheroes.service;

import java.util.List;

import com.project.superheroes.model.Superhero;

public interface SuperheroService {
	Superhero createSuperhero(Superhero superhero);

	Superhero updatedSuperhero(Superhero superhero);

	List<Superhero> getAllSuperheroes();
	
	List<Superhero> getAllSuperheroesByPartName(String name);

	Superhero getSuperheroById(long superheroId);

	void deleteSuperhero(long id);
	

}
