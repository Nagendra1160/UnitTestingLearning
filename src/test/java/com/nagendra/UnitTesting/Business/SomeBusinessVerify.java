package com.nagendra.UnitTesting.Business;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import static org.mockito.Mockito.mock;
import java.util.List;

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

}
