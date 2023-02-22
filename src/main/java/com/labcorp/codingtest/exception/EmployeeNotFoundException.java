package com.labcorp.codingtest.exception;

public class EmployeeNotFoundException extends RuntimeException implements CustomException{

    private String errorCode="300";

    public EmployeeNotFoundException(String employee) {
        super(String.format("Employee %s does not exists!", employee));
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return getMessage();
    }
}
