package com.open.newfeature.jdk8;

import org.junit.Test;

import java.util.Optional;

public class optionalTest {
    /**
     * Optional的初始化
     * Optional的构造方法是私有的，所有只能通过静态方法去初始化
     */
    @Test
    public void example1(){
        //of 为指定的类型值创建一个Optional，如果给定的值为null则会报空指针异常
        Optional<String> optional = Optional.of("Hello Optional");
        System.out.println(optional.get()); //打印：Hello Optional

        //ofNullable 为指定的类型值创建一个Optional，它与of的区别在于可以传null，当值为null时则创建一个空的Optional
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o instanceof Optional); //打印：true

        //empty 获取Optional的静态初始化空对象，单例实现，全局唯一
        Optional<Object> empty = Optional.empty();
        System.out.println(o == empty); //打印：true
    }

    /**
     * Optional的isPresent方法：如果值存在返回true，否则返回false
     */
    @Test
    public void example2(){
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.isPresent()); //打印：false

        Optional<String> optional = Optional.ofNullable("Hello Optional");
        System.out.println(optional.isPresent()); //打印：true
    }

    /**
     * Optional的get方法：如果值存在则返回，否则抛出NoSuchElementException异常
     */
    @Test
    public void example3(){
        Optional<String> optional = Optional.ofNullable("Hello Optional");
        System.out.println(optional.get()); //打印：Hello Optional

        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.get()); //抛出：NoSuchElementException异常
    }
}
