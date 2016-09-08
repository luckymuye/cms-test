package com.lvshi0797.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_person")
public class Person {
	private int p_id;
	private String username;
	private Card card;
	@OneToOne(cascade=CascadeType.REMOVE)
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	@Id
	@GeneratedValue
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String username, Card card) {
		super();
		this.username = username;
		this.card = card;
	}
 
	

}
