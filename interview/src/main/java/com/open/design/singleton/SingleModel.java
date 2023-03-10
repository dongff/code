package com.open.design.singleton;

public class SingleModel {

    //整个应用程序中只有一个自己的实例
    private static SingleModel singleModel = new SingleModel();

    //只能自己创建自己
    private SingleModel() {
    }

    //需要提供一个方法让外界调用获取实例
    public static SingleModel getInstance(){
        return singleModel;
    }
}
