package com.labcorp.codingtest.domain;

public class Manager extends Salaried{
    public static final Float VACATION_DAYS = 30f;

    public Manager() {
        super(VACATION_DAYS);
    }

}
