package com.nagendra.UnitTesting.Business;


import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import static org.mockito.Mockito.mock;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
public class SomeBusinessVerify {


    //SomeBusiness sb=mock(SomeBusiness.class);
    List<String> m = mock(List.class);
    String val1=m.get(0);

    @Test
    public void verifyMethod() {
        verify(m).get(0);
    }

    @Test
    public void arguementCapture() //It is used to check correct arguement/Parameter passed or not
    {
        m.add("Nagendr1a");
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(m).add(captor.capture());
        assertEquals("Nagendr1a",captor.getValue());

    }

    @Test
    public void multipleArguementCapture()
    {
        m.add("Nagendra1");
        m.add("Nagendra2");
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(m,times(2)).add(captor.capture());
        List<String> allvalues=captor.getAllValues();
        assertEquals("Nagendra1",allvalues.get(0));
        assertEquals("Nagendra2",allvalues.get(1));


    }

}
