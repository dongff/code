package com.open.collection;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                arrayList.remove(integer);
            }
        }

//        Map<Integer,String> map=new HashMap();
//        map.put(1,"java");
//        map.put(2,"c++");
//        map.put(3,"python");
//        Iterator<Map.Entry<Integer,String>> iterator=map.entrySet().iterator();
//        while(((Iterator) iterator).hasNext()){
//            Map.Entry<Integer,String> entry=iterator.next();
//            map.remove(entry);
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }

    }
}
