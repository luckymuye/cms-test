package com.lvshi0797.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="t_employee")
public class Employee {
	private int e_id;
	private String name;
	private Company company;
	@Id
	@GeneratedValue
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	@Column(length=36)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne//(targetEntity=Company.class) 这个也是非必要的
	@JoinColumn(name="c_id")//非必须要的注解JoinColumn(name="c_id")，加上这个只是能让列名更明确为c_id
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Employee() {
		super();
	}
	public Employee(String name, Company company) {
		super();
		this.name = name;
		this.company = company;
	}

}
