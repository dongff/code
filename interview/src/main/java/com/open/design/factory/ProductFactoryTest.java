package com.open.design.factory;

public class ProductFactoryTest {

    public static void main(String[] args) {
        Product mobile = ProductFactory.getBean("mobile");
        Product car = ProductFactory.getBean("car");
        mobile.show();
        car.show();
    }
}
