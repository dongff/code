package com.open.newfeature.jdk9_12;

public interface OrderPay {
    void pay();

    default void defaultPay() {
        privateMethod();
    }

    //接口的私有方法可以在JDK9中使用
    private void privateMethod() {
        System.out.println("调用接口的私有方法");
    }
}