package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="person")
public class Person {

	@Id
	@GeneratedValue
	private int Id;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Phones> phones=new ArrayList<>();
	public Person(){
		
	}
	public List<Phones> getPhones() {
		return phones;
	}
	public void setPhones(List<Phones> phones) {
		this.phones = phones;
	}




}
