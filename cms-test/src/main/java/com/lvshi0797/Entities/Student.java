package com.lvshi0797.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 学生对象实体，与教室为多对一的关系，由多的一方维护实体信息
 * @author Administrator
 *
 */
@Entity
@Table(name="t_student")
public class Student {
	private int s_id;
	private String username;
	private Clazzroom clazzroom;
	@Id
	@GeneratedValue
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@ManyToOne
	public Clazzroom getClazzroom() {
		return clazzroom;
	}
	public void setClazzroom(Clazzroom clazzroom) {
		this.clazzroom = clazzroom;
	}
	public Student() {
	}
	public Student(String username, Clazzroom clazzroom) {
		this.username = username;
		this.clazzroom = clazzroom;
	}
	
	
	
}
