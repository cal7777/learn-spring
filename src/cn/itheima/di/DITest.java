package cn.itheima.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

	// 测试构造方法注入
	@Test
	public void test1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car) applicationContext.getBean("car");
		System.out.println(car.getName() + "  " + car.getPrice());
	}

	// 测试setter方法注入
	@Test
	public void test2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car) applicationContext.getBean("car1");
		System.out.println(car.getName() + "  " + car.getPrice());

	}

	@Test
	public void test3() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person.getName() + "  " + person.getCar().getName());
	}

	// 测试集合属性注入---List
	@Test
	public void test4() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionDemo cd = (CollectionDemo) applicationContext.getBean("collectionDemo");

		System.out.println(cd.getList());
	}

	// 测试集合属性注入---Set
	@Test
	public void test5() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionDemo cd = (CollectionDemo) applicationContext.getBean("collectionDemo");

		System.out.println(cd.getSet());
	}

	// 测试集合属性注入---Map
	@Test
	public void test6() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionDemo cd = (CollectionDemo) applicationContext.getBean("collectionDemo");

		System.out.println(cd.getMap());
	}
	
	// 测试集合属性注入---Properties
		@Test
		public void test7() {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			CollectionDemo cd = (CollectionDemo) applicationContext.getBean("collectionDemo");

			System.out.println(cd.getProps());
		}
}
