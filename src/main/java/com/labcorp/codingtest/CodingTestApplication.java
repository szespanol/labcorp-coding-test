package com.labcorp.codingtest;

import com.labcorp.codingtest.domain.Employee;
import com.labcorp.codingtest.domain.Hourly;
import com.labcorp.codingtest.domain.Manager;
import com.labcorp.codingtest.domain.Salaried;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CodingTestApplication {

	public static Map<String, Employee> employees = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(CodingTestApplication.class, args);
	}

	@PostConstruct
	public void initialize(){
		System.out.println("Initializing...");

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
