package cn.itheima.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {

	@Test
	public void test1() {
		// 原来我们使用service
		// IUserService userService = new UserServiceImpl();
		// userService.sayHello();

		// 使用spring容器提供的ioc
		// ioc本质上就是通过 xml配置文件 +反射+factory来实现.
		// 在spring中提供一个BeanFactory工厂，我们一般使用的是它的一个子接口ApplicationContext

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ClassPathXmlApplicationContext
		// 它可以帮助我们在classpath路径下查找applicationContext.xml配置文件

		IUserService userService = (IUserService) applicationContext.getBean("userService");

		userService.sayHello();

	}
}
