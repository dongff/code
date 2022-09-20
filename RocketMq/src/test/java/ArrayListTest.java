import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-09-19 17:15
 * @modified By:
 */
@SpringBootTest
public class ArrayListTest {

    @Test
    public void array(){

        int[] arr={1,2,3};
        arr[2]=2;

        List list = new ArrayList<>();
        list.add("aa");
        list.add(1);
        System.out.println(list);

        int $e是el=3;

    }
}
