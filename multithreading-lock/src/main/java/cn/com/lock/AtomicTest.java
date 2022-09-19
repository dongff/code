package cn.com.lock;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-05 14:12
 * @modified By:
 */

public class AtomicTest {

    private AtomicInteger data = new AtomicInteger(0);

    String s ="q";


    LongAdder datal=new LongAdder();

    @Test
    public void increment() throws Exception{
        data.incrementAndGet();


        StringBuilder sbd=  new StringBuilder();
        sbd.append("ee");

        StringBuffer abf =new StringBuffer();
        abf.append("xx");
    }


}
