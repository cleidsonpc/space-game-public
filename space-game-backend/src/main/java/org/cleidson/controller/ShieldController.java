package org.cleidson.controller;

import jakarta.validation.Valid;
import org.cleidson.controller.dto.ShieldDto;
import org.cleidson.mapper.ShieldMapper;
import org.cleidson.service.ShieldService;
import org.cleidson.service.entity.Shield;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/shield")
public class ShieldController {

    private static final Logger LOG = LoggerFactory.getLogger(ShieldController.class);

    final ShieldService shieldService;

    @Autowired
    public ShieldController(ShieldService shieldService) {
        this.shieldService = shieldService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ShieldDto> update(@RequestBody @Valid ShieldDto shieldDto) {
        LOG.info("update with parameters: shieldDto={}", shieldDto);

        Shield shield = ShieldMapper.dtoToEntity(shieldDto);
        Shield responseEntity = shieldService.update(shield);
        ShieldDto response = ShieldMapper.entityToDto(responseEntity);
        return ResponseEntity.ok().body(response);
    }
}
