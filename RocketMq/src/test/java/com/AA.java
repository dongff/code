package com;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-21 9:19
 * @modified By:
 */
public class AA extends A {
    public AA() {
        System.out.print("AA");
    }

    public static void main(String[] args) {
        int q=1;
        System.out.println(Math.random());

        AA aa = new AA();
        int $ss = 2;
    }

    public   class B {

        public B() {
            System.out.print("B");
        }
    }
}

class A {
    public A() {
        System.out.print("B");
    }
}
