package com.project.superheroes.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "superheroes")


public class Superhero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "superPower")
	private String superPower;
	
	@Column(name = "age")
	private BigDecimal age;
	
	@CreationTimestamp
	private Date createdAte;
	
	@CreationTimestamp
	private Date updatedAte;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuperPower() {
		return superPower;
	}
	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}
	public BigDecimal getAge() {
		return age;
	}
	public void setAge(BigDecimal age) {
		this.age = age;
	}
	public Date getCreatedAte() {
		return createdAte;
	}
	public void setCreatedAte(Date createdAte) {
		this.createdAte = createdAte;
	}
	public Date getUpdatedAte() {
		return updatedAte;
	}
	public void setUpdatedAte(Date updatedAte) {
		this.updatedAte = updatedAte;
	}
	
	

}
