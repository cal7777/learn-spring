package cn.itheima.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanTest {

	// 使用BeanFactory来获取Bean1
	@Test
	public void test1() {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		Bean1 bean1 = (Bean1) factory.getBean("bean1");
		bean1.show();
	}

	// 使用ClassPathXmlApplicationContext来获取Bean1
	@Test
	public void test2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
		bean1.show();
	}

	// FileSystemXmlApplicationContext
	@Test
	public void test3() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
		bean1.show();
	}

	// 静态工厂方法获取Bean
	@Test
	public void test4() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
		bean2.show();
	}

	// 实例工厂方法获取Bean
	@Test
	public void test5() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
		bean3.show();
	}

	// 测试bean的scope属性
	@Test
	public void test6() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
		Bean1 bean11 = (Bean1) applicationContext.getBean("bean1");
		// System.out.println(bean1 == bean11); //scope=singleton true
		// System.out.println(bean1 == bean11); //scope=prototype false
	}

	// 测试bean的生命周期
	@Test
	public void test7() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanLifeCycle beanLife = (BeanLifeCycle) applicationContext.getBean("beanLifeCycle");
		beanLife.add();
		applicationContext.close();
	}

}
