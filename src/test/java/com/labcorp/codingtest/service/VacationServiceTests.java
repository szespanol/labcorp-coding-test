package com.labcorp.codingtest.service;

import com.labcorp.codingtest.domain.Employee;
import com.labcorp.codingtest.exception.EmployeeNotFoundException;
import com.labcorp.codingtest.exception.VacationDaysException;
import com.labcorp.codingtest.exception.WorkedDaysException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class VacationServiceTests {

    @TestConfiguration
    static class VacationServiceTestsContextConfiguration {
        @Bean
        public VacationService vacationService() {
            return new VacationServiceImpl();
        }
    }

    @Autowired
    VacationService vacationService;

    @Test(expected = WorkedDaysException.class)
    public void whenWorkedDaysGreaterThan260Days_thenThrowWorkedDaysException() {
        String name="Hourly1";
        Integer workedDays = 261;
        vacationService.setWorkedDays(name, workedDays);
    }

    @Test(expected = VacationDaysException.class)
    public void whenHourlyVacationDaysGreaterThanWorkedDays_thenThrowVacationDaysException() {
        String name="Hourly1";
        Integer workedDays = 260;
        vacationService.setWorkedDays(name, workedDays);

        Float vacationUsed = 11f;
        vacationService.takeVacation(name,vacationUsed);
    }

    @Test(expected = VacationDaysException.class)
    public void whenSalariedVacationDaysGreaterThanWorkedDays_thenThrowVacationDaysException() {
        String name="Salaried1";
        Integer workedDays = 260;
        vacationService.setWorkedDays(name, workedDays);

        Float vacationUsed = 16f;
        vacationService.takeVacation(name,vacationUsed);
    }

    @Test(expected = VacationDaysException.class)
    public void whenManagerVacationDaysGreaterThanWorkedDays_thenThrowVacationDaysException() {
        String name="Manager1";
        Integer workedDays = 260;
        vacationService.setWorkedDays(name, workedDays);

        Float vacationUsed = 31f;
        vacationService.takeVacation(name,vacationUsed);
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void whenEmployeeDoesNotExists_thenThrowException() {
        String name="Employee";
        Integer workedDays = 260;
        vacationService.setWorkedDays(name, workedDays);

    }

    @Test
    public void whenReportIsInvoked_thenReturnHourlyEmployeeStatus(){

        String name="Hourly2";
        Integer workedDays = 260;
        vacationService.setWorkedDays(name, workedDays);
        Map<String, Employee> report = vacationService.getEmployeeVacationReport();
        Employee hourly1Employee = report.get(name);
        Float accumulatedVacationDays = hourly1Employee.getAccumulatedVacationDays();
        Float expectedValue = 10f;
        assertEquals(accumulatedVacationDays, expectedValue);

    }

    @Test
    public void whenReportIsInvoked_thenReturnSalariedEmployeeStatus(){

        String name="Salaried2";
        Integer workedDays = 260;
        vacationService.setWorkedDays(name, workedDays);
        Map<String, Employee> report = vacationService.getEmployeeVacationReport();
        Employee hourly1Employee = report.get(name);
        Float accumulatedVacationDays = hourly1Employee.getAccumulatedVacationDays();
        Float expectedValue = 15f;
        assertEquals(accumulatedVacationDays, expectedValue);

    }

    @Test
    public void whenReportIsInvoked_thenReturnManagerEmployeeStatus(){

        String name="Manager2";
        Integer workedDays = 260;
        vacationService.setWorkedDays(name, workedDays);
        Map<String, Employee> report = vacationService.getEmployeeVacationReport();
        Employee hourly1Employee = report.get(name);
        Float accumulatedVacationDays = hourly1Employee.getAccumulatedVacationDays();
        Float expectedValue = 30f;
        assertEquals(accumulatedVacationDays, expectedValue);

    }

}
