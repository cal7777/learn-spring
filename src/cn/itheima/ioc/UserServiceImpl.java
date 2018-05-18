package cn.itheima.ioc;

public class UserServiceImpl implements IUserService {

	private String info;

	@Override
	public void sayHello() {
		System.out.println("hello " + info);
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
