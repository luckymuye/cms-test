package com.lvshi0797.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 教室实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="t_clazzroom")
public class Clazzroom {
	private int c_id;
	private String clazzName;
	@Id
	@GeneratedValue
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	public Clazzroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clazzroom(String clazzName) {
		super();
		this.clazzName = clazzName;
	}
	
	
}
