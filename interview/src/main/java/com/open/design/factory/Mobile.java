package com.open.design.factory;

public class Mobile implements Product {
    //产品详情
    @Override
    public void show() {
        System.out.println("手机：HUAWEI P40 Pro +");
    }
}
