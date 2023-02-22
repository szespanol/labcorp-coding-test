package com.labcorp.codingtest.exception;

public class VacationDaysException  extends RuntimeException implements CustomException{
    private String errorCode="200";
    public VacationDaysException(Float vacationDays, Float accumulatedVacationDays) {
        super(String.format("Vacation days [%s] requested cannot be greater than accumulated vacation days [%s]!", vacationDays,accumulatedVacationDays));
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return getMessage();
    }
}
