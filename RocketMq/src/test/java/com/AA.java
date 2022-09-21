package com;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-21 9:19
 * @modified By:
 */
public class  AA extends A {
    public AA(){
        System.out.print("AA");
    }

    public static void main(String[] args) {
        AA aa = new AA();
            int $ss=2;
    }
}

class A {
    public A(){
        System.out.print("B");
    }
}
