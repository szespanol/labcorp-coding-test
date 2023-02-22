package com.labcorp.codingtest.domain;

public class RequestParameter {
    private String Name;

    private String numberOfDays;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}
