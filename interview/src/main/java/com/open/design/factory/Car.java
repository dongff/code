package com.open.design.factory;

public class Car implements Product {
    @Override
    public void show() {
        System.out.println("汽车：比亚迪！");
    }
}
