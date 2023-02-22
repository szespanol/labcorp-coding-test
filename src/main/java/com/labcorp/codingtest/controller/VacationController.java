package com.labcorp.codingtest.controller;

import com.labcorp.codingtest.domain.Employee;
import com.labcorp.codingtest.domain.RequestParameter;
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

    @PostMapping("/worked-days")
    public ResponseEntity<String> setWorkedDays(@RequestBody RequestParameter parameter) {
        service.setWorkedDays(parameter.getName(), Integer.valueOf(parameter.getNumberOfDays()));
        return ResponseEntity.ok("Success!");
    }

    @PostMapping("/take-vacation")
    public ResponseEntity<String> takeVacation(@RequestBody RequestParameter parameter) {
        service.takeVacation(parameter.getName(), Float.valueOf(parameter.getNumberOfDays()));
        return ResponseEntity.ok("Success!");
    }

    @GetMapping(value = "/report", produces = { "application/json" })
    public Map<String, Employee> getReport() {
        return service.getEmployeeVacationReport();

    }
}
