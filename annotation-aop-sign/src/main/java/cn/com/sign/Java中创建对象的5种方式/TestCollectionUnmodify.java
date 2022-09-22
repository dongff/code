package cn.com.sign.Java中创建对象的5种方式;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-22 9:05
 * @modified By:
 */
public class TestCollectionUnmodify {


    static List<String> list = new ArrayList<String>();
    static Set<String> set = new HashSet<String>();
    static Map<String, String> map = new HashMap<String, String>();

    static {
        list.add("1");
        list.add("2");
        list.add("3");

        set.add("1");
        set.add("2");
        set.add("3");

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
    }

    public static void main(String[] args) {

        List<String> l = Arrays.asList("1", "2", "3", "1");
        l.remove("1");
        Set<String> s = new HashSet<String>(l);
        System.out.println(s);

        //TreeSet <String>  al =new TreeSet ();
        //al.add("1");
        //al.add(null);
        //al.add("2");
        //System.out.println(al);


        //TreeSet ts=new TreeSet();
        //ts.add("1");
        //ts.add("1");
        //System.out.println(ts);


        ConcurrentHashMap hm= new ConcurrentHashMap ();
        hm.put(null,"xxx");
        hm.put("1","xxx2");
        hm.put("3","xxx3");

        hm.values();
        hm.keySet();

        hm.remove("1");



        //System.out.println(hm.get("1"));
        //
        //System.out.println(hm);

        //list = Collections.unmodifiableList(list);
        //set = Collections.unmodifiableSet(set);
        //map = Collections.unmodifiableMap(map);
        //listModify();
        //setModify();
        //mapModify();
    }

    public static void listModify() {
        list.add("4");
    }

    public static void setModify() {
        set.add("4");
    }

    public static void mapModify() {
        map.put("3", "4");
    }
}
