package com.project.superheroes;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.superheroes.controller.SuperheroController;
import com.project.superheroes.model.Superhero;
import com.project.superheroes.repository.SuperheroRepository;
import com.project.superheroes.service.SuperheroService;

@SpringBootTest
public class SuperHeroesApplicationTests {
	
	@InjectMocks
	SuperheroController superheroController = Mockito.mock(SuperheroController.class);
	
	@Mock
	private SuperheroService superheroService;
	
	@Mock
	private SuperheroRepository superheroRepository;
	
	HttpStatus httpStatusOK = HttpStatus.OK;
	HttpStatus httpStatusISE = HttpStatus.INTERNAL_SERVER_ERROR;

	@Test
	void getAllSuperheroes() {			
		List<Superhero> serviceResp = new ArrayList<Superhero>();
		
		Mockito.when(superheroRepository.findAll()).thenReturn(serviceResp);
		ResponseEntity<List<Superhero>> response = new ResponseEntity<List<Superhero>>(serviceResp, httpStatusOK);
		Mockito.when(superheroController.getAllSuperheroes()).thenReturn(response);
	}
	
	@Test
	void getAllSuperheroesKO()  {
		
		
		Mockito.when(superheroRepository.findAll()).thenReturn(null);
		ResponseEntity<List<Superhero>> response = new ResponseEntity<List<Superhero>>(httpStatusISE);
		Mockito.when(superheroController.getAllSuperheroes()).thenReturn(response);
	}
	
	@Test
	void getAllSuperheroesByPartName() {
		List<Superhero> serviceResp = new ArrayList<Superhero>();
		
		Mockito.when(superheroService.getAllSuperheroesByPartName(new String())).thenReturn(serviceResp);
		ResponseEntity<List<Superhero>> response = new ResponseEntity<List<Superhero>>(serviceResp, httpStatusOK);
		Mockito.when(superheroController.getAllSuperheroesByPartName(new String())).thenReturn(response);
	}
	
	@Test
	void getAllSuperheroesByPartNameEmpty() {
		List<Superhero> serviceResp = new ArrayList<Superhero>();
		
		Mockito.when(superheroService.getAllSuperheroesByPartName(new String())).thenReturn(null);
		ResponseEntity<List<Superhero>> response = new ResponseEntity<List<Superhero>>(serviceResp, httpStatusOK);
		Mockito.when(superheroController.getAllSuperheroesByPartName(new String())).thenReturn(response);
	}
	
	@Test
	void updatedSuperhero() {
		Superhero serviceReq = new Superhero();
		Superhero serviceResp = new Superhero();
		long id = 1;
		
		Mockito.when(superheroService.updatedSuperhero(serviceReq)).thenReturn(serviceResp);
		ResponseEntity<Superhero> response = new ResponseEntity<Superhero>(serviceResp, httpStatusOK);
		Mockito.when(superheroController.updateSuperhero(id, serviceResp)).thenReturn(response);
		
	}
	
	@Test
	void updatedSuperheroKO() {
		Superhero serviceReq = new Superhero();
		Superhero serviceResp = new Superhero();
		long id = 0;
		
		Mockito.when(superheroService.updatedSuperhero(serviceReq)).thenReturn(serviceResp);
		ResponseEntity<Superhero> response = new ResponseEntity<Superhero>(httpStatusISE);
		Mockito.when(superheroController.updateSuperhero(id, serviceResp)).thenReturn(response);
		
	}

}
