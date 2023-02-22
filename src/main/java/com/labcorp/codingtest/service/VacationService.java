package com.labcorp.codingtest.service;

import com.labcorp.codingtest.CodingTestApplication;
import com.labcorp.codingtest.domain.Employee;
import com.labcorp.codingtest.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VacationService {

    public void setWorkedDays(String name, Integer workedDays) {
        Employee employee = getEmployee(name);
        employee.work(workedDays);
    }

    public void takeVacation(String name, Float vacationDaysUsed) {
        Employee employee = getEmployee(name);
        employee.takeVacation(vacationDaysUsed);
    }

    public Map<String, Employee> getEmployeeVacationReport() {
        return CodingTestApplication.employees;
    }

    private static Employee getEmployee(String name) {
        Employee employee = CodingTestApplication.employees.get(name);
        if(employee == null){
            throw new EmployeeNotFoundException(name);
        }
        return employee;
    }

}
