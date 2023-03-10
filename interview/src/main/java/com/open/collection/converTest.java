package com.open.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class converTest {
    public static void main(String[] args) {
        //list集合转换成数组
        ArrayList<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Object[] arr=list.toArray();
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        //数组转换为list集合
        String[] arr2={"a","b","c"};
        List<String> asList= Arrays.asList(arr2);
        for(int i=0;i<asList.size();i++){
            System.out.println(asList.get(i));
        }
    }
}
