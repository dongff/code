package cn.com.sign.Java中创建对象的5种方式;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-19 17:15
 * @modified By:
 */
@SpringBootTest
public class NewClassTest {

    @Test
    public void Java中创建对象的5种方式() throws Exception {

        //1.使用new关键字 } → 调用了构造函数
        OrderStepTest step1 = new OrderStepTest();
        System.out.println(step1 + ", hashcode : " + step1.hashCode());

        //2.使用Class类的newInstance方法 } → 调用了构造函数
        OrderStepTest step2 = (OrderStepTest) Class.forName("com.OrderStepTest").newInstance();
        System.out.println(step2 + ", hashcode : " + step2.hashCode());

        //使用Constructor类的newInstance方法 	} → 调用了构造函数
        Constructor<OrderStepTest> constructor = OrderStepTest.class.getConstructor();
        OrderStepTest step3 = constructor.newInstance();
        System.out.println(step3 + ", hashcode : " + step3.hashCode());

        //使用clone方法 	} → 没有调用构造函数
        // 要使用clone方法，我们需要先实现Cloneable接口并实现其定义的clone方法。
        OrderStepTest step4 = (OrderStepTest) step1.clone();
        System.out.println(step4 + ", hashcode : " + step4.hashCode());

        //使用反序列化 	} → 没有调用构造函数
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("ArrayListTest.java"));
        OrderStepTest step5 = (OrderStepTest) in.readObject();
        System.out.println(step5 + ", hashcode : " + step5.hashCode());
        if (step5.equals(step1)) {

        }

    }

    /**
     * 订单的步骤
     */
    protected class OrderStepTest implements Cloneable, Serializable {
        private long orderId;
        private String desc;

        public long getOrderId() {
            return orderId;
        }

        public void setOrderId(long orderId) {
            this.orderId = orderId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "OrderStepTest{" +
                    "orderId=" + orderId +
                    ", desc='" + desc + '\'' +
                    '}';
        }

        @Override
        public OrderStepTest clone() throws CloneNotSupportedException {
            return (OrderStepTest) super.clone();
        }
    }

    public static void main(String[] args) {
        System.out.println(getString());
    }

    public static String getString() {
        String str = "A";
        try {
            str = "B";
           // System.exit(0);

            return str;
        } finally {
            System.out.println("finally change return string to C");
            str = "C";
            return str;
        }
    }





}
