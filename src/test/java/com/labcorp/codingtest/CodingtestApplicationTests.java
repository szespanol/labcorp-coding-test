package com.labcorp.codingtest;

import com.labcorp.codingtest.controller.VacationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CodingtestApplicationTests {

	@Autowired
	VacationController vacationController;

	@Test
	void contextLoads() {
		assertThat(vacationController).isNotNull();
	}

}
