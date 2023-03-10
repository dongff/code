package com.open.reflect;

public class Fruit {
    public Fruit() {
        System.out.println("无参构造器Run...........");
    }

    public Fruit(String type) {
        System.out.println("有参构造器Run..........." + type);
    }
}