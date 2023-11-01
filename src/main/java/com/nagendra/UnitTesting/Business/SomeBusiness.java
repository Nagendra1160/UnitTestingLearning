package com.nagendra.UnitTesting.Business;

import com.nagendra.UnitTesting.data.SomeDataService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SomeBusiness {

    SomeDataService sds;

    public void setSds(SomeDataService sds) {
        this.sds = sds;
    }

    int findSum(int a[])
    {
        return Arrays.stream(a).sum();
    }

    int findSum()
    {
        return Arrays.stream(sds.retrieveAllData()).sum();
    }

    void Method()
    {
        System.out.println("Hi Nagendra");
    }
    public static void main(String[] args) {
       new SomeBusiness().Method();
    }

}
