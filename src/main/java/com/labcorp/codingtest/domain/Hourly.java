package com.labcorp.codingtest.domain;

import com.labcorp.codingtest.exception.WorkedDaysException;

public class Hourly extends Employee{
    public static final Float VACATION_DAYS = 10f;

    public Hourly(){
        super(VACATION_DAYS);
    }

}
