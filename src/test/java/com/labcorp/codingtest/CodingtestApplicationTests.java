package com.labcorp.codingtest;

import com.labcorp.codingtest.controller.VacationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CodingtestApplicationTests {

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	VacationController vacationController;

	@Test
	void contextLoads() {
		assertThat(vacationController).isNotNull();
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void employeeReportTest() throws Exception {
		String result =   "{\"Salaried9\":{\"workedDays\":0,\"accumulatedVacationDays\":0.0,\"vacationDaysUsed\":0.0}";
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vacation/report",
				String.class)).contains(result);
	}

}
