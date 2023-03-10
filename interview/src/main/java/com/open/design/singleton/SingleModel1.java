package com.open.design.singleton;

public class SingleModel1 {
    //整个应用程序中只有一个自己的实例
    private static SingleModel1 singleModel;

    //只能自己创建自己
    private SingleModel1() {
    }

    //需要提供一个方法让外界调用获取实例
    public static synchronized SingleModel1 getInstance(){
        if(singleModel==null){
            singleModel = new SingleModel1();
        }
        return singleModel;
    }
}
