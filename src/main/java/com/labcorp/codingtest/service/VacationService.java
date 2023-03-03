package com.labcorp.codingtest.service;

import com.labcorp.codingtest.CodingTestApplication;
import com.labcorp.codingtest.domain.Employee;

import java.util.Map;

public interface VacationService {

    void setWorkedDays(String name, Integer workedDays);

    void takeVacation(String name, Float vacationDaysUsed);

    Map<String, Employee> getEmployeeVacationReport() ;
}
