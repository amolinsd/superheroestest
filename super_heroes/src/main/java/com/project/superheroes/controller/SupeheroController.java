package com.project.superheroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.superheroes.model.Superhero;
import com.project.superheroes.service.SuperheroService;

@RestController
public class SupeheroController {
	
	@Autowired
	private SuperheroService superheroService;
	
	@GetMapping("/superheroes")
	public ResponseEntity<List<Superhero>> getAllSuperheroes(){
		return ResponseEntity.ok().body(superheroService.getAllSuperheroes());
	}
	
	@GetMapping("/superheroes/{id}")
	public ResponseEntity<Superhero> getAllSuperheroesById(@PathVariable long id){
		return ResponseEntity.ok().body(superheroService.getSuperheroById(id));
	}
	
	@GetMapping("/superheroes/name/{name}")
	public ResponseEntity<List<Superhero>> getAllSuperheroesByPartName(@PathVariable String name){
		return ResponseEntity.ok().body(superheroService.getAllSuperheroesByPartName(name));
	}

	@PostMapping("/superheroes")
	public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero){
		return ResponseEntity.ok().body(this.superheroService.createSuperhero(superhero));
	}
	
	@PutMapping("/superheroes/{id}")
	public ResponseEntity<Superhero> updateSuperhero(@PathVariable long id,@RequestBody Superhero superhero){
		superhero.setId(id);
		return ResponseEntity.ok().body(this.superheroService.updatedSuperhero(superhero));
	}
	
	@DeleteMapping("/superheroes/{id}")
	public HttpStatus deleteSuperhero(@PathVariable long id){
		this.superheroService.deleteSuperhero(id);
		return HttpStatus.OK;
	}
}
