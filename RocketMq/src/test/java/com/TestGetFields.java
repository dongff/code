package com;

import java.lang.reflect.Field;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-21 15:33
 * @modified By:
 */
public class TestGetFields extends TestGetFieldsSub implements TestGetFieldsInterface{
    private String privateFieldSelf;
    protected String protectedFieldSelf;
    String defaultFieldSelf;
    public String publicFieldSelf;


    public static void main(String[] args) {
        System.out.println("--------  getFields  --------");
        for (Field field : TestGetFields.class.getFields()) {
            System.out.println(field.getName());
        }

        System.out.println("--------  getDeclaredFields  --------");
        for (Field field : TestGetFields.class.getDeclaredFields()) {
            System.out.println(field.getName());
        }
    }
}

class TestGetFieldsSub {
    private String privateField;
    protected String protectedField;
    String defaultField;
    public String publicField;
}

interface TestGetFieldsInterface {
    String interfaceField = "";
}