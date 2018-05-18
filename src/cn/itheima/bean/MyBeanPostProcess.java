package cn.itheima.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcess implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第五步:beanPostProcessor的before方法");
		System.out.println("处理的bean是" + bean + " 它的名称是" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		System.out.println("第八步:beanPostProcessor的after方法");

		if (beanName.equals("beanLifeCycle")) {
			// 使用动态代理可以处理bean的功能增强
			Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
					new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							if (method.getName().equals("add")) {
								long currentTimeMillis = System.currentTimeMillis();
								Object invoke = method.invoke(bean, args);
								long currentTimeMillis2 = System.currentTimeMillis();
								return invoke;
							} else {
								return method.invoke(bean, args);
							}
						}
					});
		}

		return bean;
	}

}
