package com.lvshi0797.test;

import java.util.HashSet;
import java.util.Set;

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
import com.lvshi0797.Entities.Card;
import com.lvshi0797.Entities.Clazzroom;
import com.lvshi0797.Entities.Company;
import com.lvshi0797.Entities.Employee;
import com.lvshi0797.Entities.Person;
import com.lvshi0797.Entities.Student;
import com.lvshi0797.Entities.Teacher;

public class SaveTableTest {
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
	public void testOneToManySingle(){
		transaction = session.beginTransaction();
		Clazzroom c = new Clazzroom("高三一班");
		Student s1 = new Student("李心艾", c);
		Student s2 = new Student("张心艾", c);
		Student s3 = new Student("肖艾", c);
	
		
		session.save(c);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		transaction.commit();
	}
	@Test
	public void testOneToMany(){
		//根据公司查看该公司下的所有员工
		Company c =(Company) session.get(Company.class, 1);
		Set<Employee> s = c.getEmployees();
		//如果不执行下面的for循环，将不会执行查询Employee对象的语句
		for(Employee e:s ){
			System.out.println(e.getName());
		}
		//根据员工查出对应的公司信息
		Employee e = (Employee) session.get(Employee.class, 3);
		Company company = e.getCompany();
		
		System.out.println(company.getC_name());
		
	}
	
	
	
	/**
	 * 测试一对多的关系，以 Company和Employee对象为例， 双向维护 
	 */
//	@Test
	public void testOneToManyDouble(){
		transaction = session.beginTransaction();
		Company c = new Company("一红宇");
		
		Employee e1 = new Employee("黎明1", c);
		Employee e2 = new Employee("黎明2", c);
		Employee e3 = new Employee("黎明3", c);
		
		
		Set<Employee> set = new HashSet<Employee>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		
		c.setEmployees(set);
		
		session.save(c);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		transaction.commit();
	}
	/**
	 * 测试添加 一对一 双向维护  Person 与 Card ，都有各自的维护
	 */
//	@Test
	public void testOneToOneDouble(){
		transaction = session.beginTransaction();
		Card card = new Card();
		card.setC_num("360731199205062356");
		Person p = new Person("李四", card );
		card.setPerson(p);
		session.save(p);
		session.save(card);
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
