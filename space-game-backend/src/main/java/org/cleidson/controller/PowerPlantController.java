package org.cleidson.controller;

import jakarta.validation.Valid;
import org.cleidson.controller.dto.PowerPlantDto;
import org.cleidson.mapper.PowerPlantMapper;
import org.cleidson.service.PowerPlantService;
import org.cleidson.service.entity.PowerPlant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/power_plant")
public class PowerPlantController {

    private static final Logger LOG = LoggerFactory.getLogger(PowerPlantController.class);

    final PowerPlantService powerPlantService;

    @Autowired
    public PowerPlantController(PowerPlantService powerPlantService) {
        this.powerPlantService = powerPlantService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/update")
    @ResponseBody
    public ResponseEntity<PowerPlantDto> update(@RequestBody @Valid PowerPlantDto powerPlantDto) {
        LOG.info("update with parameters: powerPlantDto={}", powerPlantDto);

        PowerPlant powerPlant = PowerPlantMapper.dtoToEntity(powerPlantDto);
        PowerPlant responseEntity = powerPlantService.update(powerPlant);
        PowerPlantDto response = PowerPlantMapper.entityToDto(responseEntity);
        return ResponseEntity.ok().body(response);
    }

}
