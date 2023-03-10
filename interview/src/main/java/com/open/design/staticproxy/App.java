package com.open.design.staticproxy;

public class App {
	public static void main(String[] args) {
		IUserDao target=new UserDao(); //多态目标对象
		IUserDao proxy=new UserDaoProxy(target);//代理对象
		//target.save();
		proxy.save();
	}

}
