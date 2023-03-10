package com.open.newfeature.jdk9_12;

public class OrderPayImpl implements OrderPay {
    @Override
    public void pay() {
        System.out.println("OrderPayImpl实现了pay()方法");
    }

    public static void main(String[] args) {
        OrderPayImpl orderPay = new OrderPayImpl();
        orderPay.defaultPay();
        orderPay.pay();
    }
}
