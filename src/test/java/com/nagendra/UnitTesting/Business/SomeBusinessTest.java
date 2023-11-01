package com.nagendra.UnitTesting.Business;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.nagendra.UnitTesting.Business.SomeBusiness;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SomeBusinessTest {
   // @Autowired
    SomeBusiness sb=new SomeBusiness();

    @Test
    public void Testing() {
        int a[] = {2, 3, 4};
        int actual_result = sb.findSum(a);
        int expected_result = 90;
        assertEquals(actual_result,expected_result);

    }

}
