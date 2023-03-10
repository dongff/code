package com.open.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class removeEqObject {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("8");
        list.add("8");
        list.add("9");
        list.add("9");
        list.add("0");
        System.out.println(list);
        // 方法:将List中数据取出来来存到Set中
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        System.out.println(set);
    }

}
