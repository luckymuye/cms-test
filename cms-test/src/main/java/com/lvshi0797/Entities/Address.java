package com.lvshi0797.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 地址
 * @author Administrator
 *
 */
@Entity
@Table(name="t_address")
public class Address {
	
	private int a_id;
	
	private String town;
	private String vallige;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String town, String vallige) {
		super();
		this.town = town;
		this.vallige = vallige;
	}
	@Id
	@GeneratedValue
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	@Column(length=32,nullable=false)
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	@Column(columnDefinition="varchar(60) default ''")
	public String getVallige() {
		return vallige;
	}
	public void setVallige(String vallige) {
		this.vallige = vallige;
	}
	
	
}
