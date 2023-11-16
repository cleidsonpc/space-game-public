package org.cleidson.controller;

import org.cleidson.controller.dto.ShieldDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShieldControllerTest {

    @LocalServerPort
    private int port;

    final private TestRestTemplate testRestTemplate;

    @Autowired
    public ShieldControllerTest(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }

    private String getServiceURL() {
        return "http://localhost:" + port + "/shield";
    }

    @Test
    void shouldUpdateShieldToDisabled() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setOrigin("http://localhost:3000");

        final String url = getServiceURL() + "/update";
        ShieldDto shieldDtoExpected = new ShieldDto(Boolean.TRUE, 1, 2);
        HttpEntity<ShieldDto> request = new HttpEntity<>(shieldDtoExpected, headers);

        ResponseEntity<ShieldDto> httpEntityObtained = testRestTemplate.postForEntity(url, request, ShieldDto.class);

        Assertions.assertEquals(HttpStatus.OK, httpEntityObtained.getStatusCode());
        Assertions.assertEquals(shieldDtoExpected, httpEntityObtained.getBody());

        // TODO: 08/08/2023 Add database validation
    }

}
