package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-21 16:18
 * @modified By:
 */
public class TestExchange {

    String str = new String("1");
    char[] arr = { 'a', 'b', 'c' };


    public static void main(String[] args) {
        TestExchange te = new TestExchange();

        te.exchange(te.str, te.arr);
        System.out.print(te.str + " ");
        System.out.print(te.arr);

    }

    public void exchange(String str, char arr[]) {

        str = "2";
        //arr = new char[0];
        arr[0] = 'd';
    }
}
