package org.cleidson.controller;

import org.cleidson.controller.dto.HealthAppStatusDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthCheckControllerTest {

    final private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

    @Autowired
    public HealthCheckControllerTest(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }

    private String getServiceURL() {
        return "http://localhost:" + port + "/health/check";
    }

    @Test
    void shouldGetHealthCheck() throws URISyntaxException {
        ResponseEntity<HealthAppStatusDto> healthObtained = testRestTemplate.getForEntity(getServiceURL(), HealthAppStatusDto.class);

        HealthAppStatusDto healthAppStatusDtoExpected = new HealthAppStatusDto(Boolean.TRUE, "App is online");

        Assertions.assertEquals(HttpStatus.OK, healthObtained.getStatusCode());
        Assertions.assertEquals(healthAppStatusDtoExpected, healthObtained.getBody());
    }

}
