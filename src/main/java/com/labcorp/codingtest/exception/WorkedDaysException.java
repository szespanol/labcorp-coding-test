package com.labcorp.codingtest.exception;

public class WorkedDaysException extends RuntimeException implements CustomException{

    private String errorCode="100";

    public WorkedDaysException(Integer annualWorkDays) {
        super(String.format("Worked Days per year cannot be greater than %s days!", annualWorkDays));
    }

    public String getErrorCode() {
        return errorCode;
    }
}
