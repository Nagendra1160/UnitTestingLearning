package com.nagendra.UnitTesting.data;

import org.springframework.stereotype.Component;

@Component
public class SomeDataServiceImpl implements SomeDataService
{

    @Override
    public int[] retrieveAllData() {
        return new int[]{12,3,4};
    }
}