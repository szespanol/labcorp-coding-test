package com.labcorp.codingtest.domain;

public class Salaried extends Employee{
    public static final Float VACATION_DAYS = 15f;

    public Salaried(Float vacationDays) {
        super(vacationDays);
    }

    public Salaried() {
        super(VACATION_DAYS);
    }

}
