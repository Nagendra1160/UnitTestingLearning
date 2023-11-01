package com.nagendra.UnitTesting.Business;

import com.nagendra.UnitTesting.data.SomeDataService;
import com.nagendra.UnitTesting.data.SomeDataServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SomeBusinessStubTest {
    @Autowired
     SomeBusiness sb;// = new SomeBusiness();
    @Autowired
    SomeDataServiceImpl sdsi;
    @Test
    public void testingUsingDataService()
    {
        sb.setSds(new SomeDataServiceImpl());
        int acutal_result= Arrays.stream(sdsi.retrieveAllData()).sum();
        int expected_result=19;
        assertEquals(acutal_result,expected_result);
    }

    @Test
    public void TestingSum() {
        int a[] = {2, 3, 4};
        int actual_result = sb.findSum(a);
        int expected_result = 9;
        assertEquals(actual_result, expected_result);
    }
}
