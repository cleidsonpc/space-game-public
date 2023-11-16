package org.cleidson.controller;

import org.cleidson.controller.dto.HealthAppStatusDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HealthCheckControllerTest {

    private HealthCheckController victim;

    @BeforeEach
    public void before() {
        this.victim = new HealthCheckController();
    }

    @Test
    void shouldGetHealthCheck() {
        ResponseEntity<HealthAppStatusDto> obtained = victim.healthCheck();

        HealthAppStatusDto expected = new HealthAppStatusDto(Boolean.TRUE, "App is online");

        Assertions.assertEquals(HttpStatus.OK, obtained.getStatusCode());
        Assertions.assertNotNull(obtained.getBody());
        Assertions.assertEquals(expected.status(), obtained.getBody().status());
        Assertions.assertEquals(expected.message(), obtained.getBody().message());
    }

}
