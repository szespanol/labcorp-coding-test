package com.labcorp.codingtest.service;

import com.labcorp.codingtest.domain.Employee;
import com.labcorp.codingtest.exception.EmployeeNotFoundException;
import com.labcorp.codingtest.repository.DataInitializer;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VacationServiceImpl implements VacationService {

    public void setWorkedDays(String name, Integer workedDays) {
        Employee employee = getEmployee(name);
        employee.work(workedDays);
    }

    public void takeVacation(String name, Float vacationDaysUsed) {
        Employee employee = getEmployee(name);
        employee.takeVacation(vacationDaysUsed);
    }

    public Map<String, Employee> getEmployeeVacationReport() {
        return DataInitializer.employees;
    }

    private static Employee getEmployee(String name) {
        Employee employee = DataInitializer.employees.get(name);
        if(employee == null){
            throw new EmployeeNotFoundException(name);
        }
        return employee;
    }

}
