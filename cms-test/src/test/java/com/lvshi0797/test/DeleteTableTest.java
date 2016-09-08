package com.lvshi0797.test;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lvshi0797.Entities.Address;
import com.lvshi0797.Entities.Clazzroom;
import com.lvshi0797.Entities.Person;
import com.lvshi0797.Entities.Student;
import com.lvshi0797.Entities.Teacher;

public class DeleteTableTest {
	public static SessionFactory sf = null;
	public static Session session = null;
	public static Transaction transaction = null;

	@BeforeClass
	public static void beforeClass() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sf = configuration.buildSessionFactory(serviceRegistry);

		// sf = new Configuration().configure().buildSessionFactory();
		session = sf.openSession();
		System.out.println("開始了");
	}
	
	/**
	 * 测试一对多的关系，以 教室和学生对象为例， 单向维护，由多方（学生）维护信息
	 */
//	@Test
	public void testOneToMany(){
		transaction = session.beginTransaction();
		//由于在Student对象维护信息，所以去删除clazzroom的时候，没有效果
		/*Clazzroom c =(Clazzroom) session.get(Clazzroom.class, 1);
		session.delete(c); */
		
		//下面删除所有与id=1的clazzroom的  Student 对象
		/*
		Student s1 = (Student) session.get(Student.class, 1);
		Student s2 = (Student) session.get(Student.class, 2);
		Student s3 = (Student) session.get(Student.class, 3);
		session.delete(s1);
		session.delete(s2);
		session.delete(s3);
		*/
		//在删除了所有的跟id=1的clazzroom对象有级联关系的Student对象之后，可以删除id=1的Clazzroom
		Clazzroom c =(Clazzroom) session.get(Clazzroom.class, 1);
		session.delete(c); 
		transaction.commit();
	}
	/**
	 *  一对一 双向维护  Person 与 Card ，都有各自的维护 删除p的时候,
	 *  在Person的getCard()方法上的oneToOne 加上 这个 cascade=CascadeType.REMOVE 之后，
	 *  可以在删除Person对象的同时删除Card对象，而不能单独删除Card对象
	 */
//	@Test
	public void testOneToOneDouble(){
		transaction = session.beginTransaction();
		Person p =(Person) session.get(Person.class, 8);
		session.delete(p); 
		transaction.commit();
	}
	
	/**
	 * 测试添加 一对一 单向维护 Teacher实体中包含一个Address实体的引用
	 */
//	@Test
	public void testOneToOneSingle() {
		transaction = session.beginTransaction();
		Teacher t = new Teacher();
		Address a = new Address("贡江镇", "洪峰村");
		t.setSchool("于都中学");
		t.setUsername("张sisi");
		t.setAddress(a);
		session.save(a);
		session.save(t);
		transaction.commit();

	}

	@AfterClass
	public static void afterClass() {
		System.out.println("結束了");
		if (session != null)
			session.close();
		if (sf != null)
			sf.close();
	}
}
