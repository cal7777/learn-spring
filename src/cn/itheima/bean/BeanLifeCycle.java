package cn.itheima.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanLifeCycle implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

	private String name;

	public BeanLifeCycle() {
		System.out.println("第一步:实例化BeanLifeCycle对象");
	}

	// 自定义功能
	public void add() {
		System.out.println("第九步:自定义功能add.....");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("第二步:属性name的注入" + name);
		this.name = name;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("第三步:得到bean的id或name值:" + name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		System.out.println("第四步:得到ApplicationContext对象:" + applicationContext);

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("第六步:属性注入完成后");
	}

	public void myInit() {
		System.out.println("第七步:自定义的init方法");
	}

	@Override
	public void destroy() throws Exception {

		System.out.println("第十步:执行destroy方法");
	}

	public void myDestroy() {
		System.out.println("第十一步:执行自定义的销毁方法");
	}

}
