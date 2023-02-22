package com.labcorp.codingtest.domain;

import com.labcorp.codingtest.exception.VacationDaysException;
import com.labcorp.codingtest.exception.WorkedDaysException;

public abstract class Employee {

    public static final Integer ANNUAL_WORK_DAYS = 260;
    private Float vacationDays;
    Integer workedDays = 0;
    Float accumulatedVacationDays = 0.0f;
    private Float vacationDaysUsed= 0.0f;

    public Employee(Float vacationDays) {
        this.vacationDays = vacationDays;
    }

    public void work(Integer workedDays) {

        if(this.getWorkedDays() + workedDays > Employee.ANNUAL_WORK_DAYS){
            throw new WorkedDaysException(Employee.ANNUAL_WORK_DAYS);
        }

        this.workedDays = this.getWorkedDays() + workedDays;
        this.accumulatedVacationDays = this.getAccumulatedVacationDays() + (workedDays * this.vacationDays  / ANNUAL_WORK_DAYS);

    }

    public void takeVacation(Float vacationDays) {
        if(this.getAccumulatedVacationDays() - vacationDays < 0){
            throw new VacationDaysException(vacationDays, this.accumulatedVacationDays);
        }

        this.accumulatedVacationDays = this.getAccumulatedVacationDays() - vacationDays;
        this.vacationDaysUsed = this.getVacationDaysUsed() + vacationDays;
    }

    public Integer getWorkedDays() {
        return workedDays;
    }

    public Float getAccumulatedVacationDays() {
        return accumulatedVacationDays;
    }

    public Float getVacationDaysUsed() {
        return vacationDaysUsed;
    }
}
