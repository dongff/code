package com.open.design.dynamicproxy;

public class App {
	public static void main(String[] args) {
		IUserDao target=new UserDao();//目标对象
		System.out.println(target.getClass());
		//代理对象
		IUserDao proxy=(IUserDao)new ProxyFactory(target).getProxyInstance();
		proxy.save();

	}
}
