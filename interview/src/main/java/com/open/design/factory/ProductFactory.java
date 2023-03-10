package com.open.design.factory;

public class ProductFactory {
    //根据用户的需求创建不同的产品
    public static Product getBean(String name){
        if(name.equals("mobile")){
            return new Mobile();
        }else if(name.equals("car")){
            return new Car();
        }
        return null;
    }
}
