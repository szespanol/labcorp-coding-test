package com.labcorp.codingtest.controller;

import com.labcorp.codingtest.domain.Employee;
import com.labcorp.codingtest.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("vacation")
public class VacationController {

    @Autowired
    private VacationService service;

    @GetMapping("/worked-days/employee/{name}")
    public ResponseEntity<String> setWorkedDays(@PathVariable(value = "name") String name,
                                                @RequestParam(value = "workedDays") Integer workedDays) {
         service.setWorkedDays(name, workedDays);
        return ResponseEntity.ok("Success!");

    }

    @GetMapping("/take-vacation/employee/{name}")
    public ResponseEntity<String> takeVacation(@PathVariable(value = "name") String name,
                                @RequestParam(value = "vacationDaysUsed") String vacationDaysUsed) {
        service.takeVacation(name, Float.valueOf(vacationDaysUsed));
        return ResponseEntity.ok("Success!");

    }

    @GetMapping(value = "/report", produces = { "application/json" })
    public Map<String, Employee> getReport() {
        return service.getEmployeeVacationReport();

    }
}
