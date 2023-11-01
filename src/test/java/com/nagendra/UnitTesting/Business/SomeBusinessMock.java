package com.nagendra.UnitTesting.Business;

import com.nagendra.UnitTesting.data.SomeDataServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@SpringBootTest
public class SomeBusinessMock {

    @Autowired
    SomeBusiness sb;
    @Test
    public void testUsingMocito() {
        SomeDataServiceImpl sdsi = mock(SomeDataServiceImpl.class);
        when(sdsi.retrieveAllData()).thenReturn(new int[]{2,3,4,5,6});
        sb.setSds(sdsi);
        int actual_result= Arrays.stream(sdsi.retrieveAllData()).sum();
        int expected_result=20;
        assertEquals(actual_result,expected_result);

    }

    @Test
    public void testingUsingMocito2()
    {
        SomeDataServiceImpl sdsi= mock(SomeDataServiceImpl.class);
        when(sdsi.retrieveAllData()).thenReturn(new int[]{2});
        //sb.setSds(sdsi);
        int a_r= Arrays.stream(sdsi.retrieveAllData()).reduce(0,(a,b)->a+b);
        int e_r=2;
        assertEquals(a_r,e_r);

    }

}
