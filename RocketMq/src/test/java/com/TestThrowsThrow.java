package com;

import java.io.IOException;

/**
 * @author: dongff
 * @description: throw：
 * 表示方法内抛出某种异常对象(只能是一个)
 * 用于程序员自行产生并抛出异常
 * 位于方法体内部，可以作为单独语句使用
 * 如果异常对象是非 RuntimeException 则需要在方法申明时加上该异常的抛出，即需要加上 throws 语句 或者 在方法体内 try catch 处理该异常，否则编译报错
 * 执行到 throw 语句则后面的语句块不再执行
 *
 * throws：
 * 方法的定义上使用 throws 表示这个方法可能抛出某些异常(可以有多个)
 * 用于声明在该方法内抛出了异常
 * 必须跟在方法参数列表的后面，不能单独使用
 * 需要由方法的调用者进行异常处理
 * @date: Created in 2022-09-20 18:43
 * @modified By:
 */
public class TestThrowsThrow {

    private void TestThrowsThrow(){
        System.out.println(11);
    }

    public static void main(String[] args) {
        testThrows();

        Integer i = null;
        testThrow(i);

        String filePath = null;
        try {
            testThrow(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试 throws 关键字
     * @throws NullPointerException
     */
    public static void testThrows() throws NullPointerException {
        Integer i = null;
        System.out.println(i + 1);
    }

    /**
     * 测试 throw 关键字抛出 运行时异常
     * @param i
     */
    public static void testThrow(Integer i) {
        if (i == null) {
            throw new NullPointerException();//运行时异常不需要在方法上申明
        }
    }

    /**
     * 测试 throw 关键字抛出 非运行时异常，需要方法体需要加 throws 异常抛出申明
     * @param
     */
    public static void testThrow(String filePath) throws IOException {
        if (filePath == null) {
            throw new IOException();//非运行时异常，需要方法体需要加 throws 异常抛出申明
        }
    }
}
