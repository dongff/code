package cn.com.HeepStacks;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-11 11:12
 * @modified By:
 */
public class OOMTest {


    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        List<byte[]> byteList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            byte[] bytes = new byte[2 * _1MB];
            byteList.add(bytes);
        }
    }
}
