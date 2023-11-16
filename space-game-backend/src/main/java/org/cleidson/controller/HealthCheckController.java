package org.cleidson.controller;

import org.cleidson.controller.dto.HealthAppStatusDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/health")
public class HealthCheckController {

    private static final Logger LOG = LoggerFactory.getLogger(HealthCheckController.class);

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/check")
    @ResponseBody
    public ResponseEntity<HealthAppStatusDto> healthCheck() {
        LOG.info("healthCheck performed.");

        HealthAppStatusDto healthAppStatusDto = new HealthAppStatusDto(Boolean.TRUE, "App is online");
        return ResponseEntity.ok().body(healthAppStatusDto);
    }
}
