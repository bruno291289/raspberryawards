package com.texoit.raspberryawards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.texoit.raspberryawards.dto.IntervalAwards;
import com.texoit.raspberryawards.repository.WinnerMaxRepository;
import com.texoit.raspberryawards.repository.WinnerMinRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RaspberryawardsApplicationTests {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private WinnerMinRepository winnerMinRepository;
	
	@Autowired
	private WinnerMaxRepository winnerMaxRepository;

	@Test
	void intervalAwardsMustMatchMinMax() {
		
		ResponseEntity<IntervalAwards> response = this.testRestTemplate.exchange(
				"/movies/intervalawards",
				HttpMethod.GET,
				null,
				IntervalAwards.class
				);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getMin(), winnerMinRepository.findAll());
		assertEquals(response.getBody().getMax(), winnerMaxRepository.findAll());
		
	}

}
