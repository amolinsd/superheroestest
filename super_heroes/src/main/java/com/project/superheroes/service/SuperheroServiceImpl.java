package com.project.superheroes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.superheroes.annotations.ExecutionTime;
import com.project.superheroes.exception.ResourceNotFoundException;
import com.project.superheroes.model.Superhero;
import com.project.superheroes.repository.SuperheroRepository;

@Service
@Transactional
public class SuperheroServiceImpl implements SuperheroService {

	@Autowired
	private SuperheroRepository superheroRepository;
	
	@Override
	public Superhero createSuperhero(Superhero superhero) {
		return superheroRepository.save(superhero);
	}

	@Override
	@ExecutionTime
	public Superhero updatedSuperhero(Superhero superhero) {
		
		Optional<Superhero> superheroDb = this.superheroRepository.findById(superhero.getId());
		
		if(superheroDb.isPresent()) {
			Superhero superheroUpdate = superheroDb.get();
			superheroUpdate.setId(superhero.getId());
			superheroUpdate.setName(superhero.getName());
			superheroUpdate.setAge(superhero.getAge());
			superheroUpdate.setSuperPower(superhero.getSuperPower());
			superheroRepository.save(superheroUpdate);
			
			long startTime = ExecutionTime.startTime;
			long finishTime = System.nanoTime() - startTime;
			
			System.out.println("Execution time: " + finishTime + " nanoseconds");
			
			System.out.println(SuperheroServiceImpl.class.getProtectionDomain().getCodeSource().getLocation());
			
			return superheroUpdate;
		}else {
			throw new ResourceNotFoundException("Superhero not found with id = "  + superhero.getId());
		}		
	}

	@Override
	public List<Superhero> getAllSuperheroes() {
		return this.superheroRepository.findAll();
	}
	
	@Override
	public List<Superhero> getAllSuperheroesByPartName(String name) {
		List<Superhero> superheroesList = getAllSuperheroes();
		
		return (List<Superhero>) superheroesList.stream().
				filter(sp -> sp.getName().contains(name)).collect(Collectors.toList());
	}

	@Override
	public Superhero getSuperheroById(long superheroId) {
		
		Optional<Superhero> superheroDb = this.superheroRepository.findById(superheroId);
		
		if(superheroDb.isPresent()) {
			return superheroDb.get();
		}else {
			throw new ResourceNotFoundException("Superhero not found with id : " + superheroId);
		}		
	}

	@Override
	public void deleteSuperhero(long superheroId) {

		Optional<Superhero> superheroDb = this.superheroRepository.findById(superheroId);
		
		if(superheroDb.isPresent()) {
			this.superheroRepository.delete(superheroDb.get());
		}else {
			throw new ResourceNotFoundException("Superhero not found with id : " + superheroId);
		}
	}

}
