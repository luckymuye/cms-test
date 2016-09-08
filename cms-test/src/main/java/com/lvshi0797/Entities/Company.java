package com.lvshi0797.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_company")
public class Company {
	private int c_id;
	private String c_name;
	private Set<Employee> employees;
	@Id
	@GeneratedValue
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	@Column(length=50)
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	@OneToMany(mappedBy="company")
	//,targetEntity=Employee.class这个属性可有可无，
	//(mappedBy="company")这个属性可以使company的id在employee表中维护，而不是新建第三个表(t_company_t_employee )去维护
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Company() {
	}
	public Company(String c_name) {
		this.c_name = c_name;
	}
	
	
	
}
