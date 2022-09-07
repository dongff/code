package cn.com.lock;

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

    LongAdder datal=new LongAdder();

    public void increment(){
        data.incrementAndGet();
    }
}
