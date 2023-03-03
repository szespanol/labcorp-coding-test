package com.labcorp.codingtest.repository;

import com.labcorp.codingtest.domain.Employee;
import com.labcorp.codingtest.domain.Hourly;
import com.labcorp.codingtest.domain.Manager;
import com.labcorp.codingtest.domain.Salaried;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataInitializer {

    public static Map<String, Employee> employees = new HashMap<>();

    static{

        System.out.println("DataInitializer is setting up data..");

        for(int ctr=1; ctr<=10; ctr++){
            employees.put("Hourly" + ctr, new Hourly());
        }

        for(int ctr=1; ctr<=10; ctr++){
            employees.put("Salaried" + ctr, new Salaried());
        }

        for(int ctr=1; ctr<=10; ctr++){
            employees.put("Manager" + ctr, new Manager());
        }

    }
}
