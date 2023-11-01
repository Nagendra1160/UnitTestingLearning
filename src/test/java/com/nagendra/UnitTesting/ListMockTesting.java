package com.nagendra.UnitTesting;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ListMockTesting {

    @Test
    public void listMocking() {
        List m = mock(List.class);
        when(m.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,m.size());
        assertEquals(10,m.size());
    }

    @Test
    public void returnParameters()
    {
        List l=mock(List.class);
       // when(l.get(0)).thenReturn(9);
        when(l.get(2)==null).thenThrow(NullPointerException.class);
        //assertEquals(9,l.get(0));
        assertEquals(10,l.get(2));
    }

}
