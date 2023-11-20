package com.nagendra.UnitTesting.Business;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;


public class MockVsSpy {

    List<String> ls=mock(List.class);

    @Test
    public void mockingTest()
    {
        ls.add("Hi");

        //mock() method load the class and does not return real object behaviour
        //instead it returns empty or default returns of that method if in case it is
        // stubbed with some data then it will check wheather it works as expected
        //here below we did not stub
        assertNull(ls.get(1));
        assertEquals(0,ls.size());
        //even i add Hi in ls it does not take real object behaviour it still returns
        //default or empty values of those called methods
        System.out.println(ls.get(0));

        //here we stubbed the value to return as expected
        when(ls.get(0)).thenReturn("Hi");
        assertEquals("Hi",ls.get(0));
    }


    @Test
    public void spyingTest()
    {
        ArrayList al=spy(ArrayList.class);
        al.add(2);
        al.add(4);
        System.out.println(al.size());


        when(al.size()).thenReturn(8);
        System.out.println(al.size());
        assertEquals(8,al.size());
        verify(al).add(3);//verifies 3 is added as parameter with add() method or not



        //al.add(3);
        //al.add(5);
        //assertEquals(2,al.size());//It takes the behaviour of real object
        //now we can override the existing real object behaviour
        //assertEquals(8,al.size());


    }
}
