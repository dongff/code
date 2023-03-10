package com.open.design.singleton;

public class SingleModel2 {
    //整个应用程序中只有一个自己的实例
    private static SingleModel2 singleModel;

    //只能自己创建自己
    private SingleModel2() {
    }

    //需要提供一个方法让外界调用获取实例
    public static SingleModel2 getInstance(){
        if(singleModel==null){
            //如果singlemodel为空，则创建对象实例
            synchronized (SingleModel2.class){
                if(singleModel==null){
                    singleModel = new SingleModel2();
                }
            }
        }
        return singleModel;
    }
}
