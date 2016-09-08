package com.lvshi0797.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_card")
public class Card {
	private int c_id;
	private String c_num;
	private Person person;
	@Id
	@GeneratedValue
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	@OneToOne
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Card() {
	}
	public Card( String c_num, Person person) {
		this.c_num = c_num;
		this.person = person;
	}
	
	
}
