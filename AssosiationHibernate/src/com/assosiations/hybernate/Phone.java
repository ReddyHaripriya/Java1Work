package com.assosiations.hybernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="Phone")
public class Phone {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="number")
	private String number;
	 
	 @ManyToOne(cascade=CascadeType.PERSIST)
	    @JoinColumn(name = "person_id",
	            foreignKey = @ForeignKey(name = "PERSON_ID_FK")

	 )
	
	 private Person person;
	 
	public Phone(String number){
		this.number=number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	

}
