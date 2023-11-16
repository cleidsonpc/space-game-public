package org.cleidson.controller;

import jakarta.validation.Valid;
import org.cleidson.controller.dto.EngineDto;
import org.cleidson.mapper.EngineMapper;
import org.cleidson.service.EngineService;
import org.cleidson.service.entity.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/engine")
public class EngineController {

    private static final Logger LOG = LoggerFactory.getLogger(EngineController.class);

    final EngineService engineService;

    @Autowired
    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/update")
    @ResponseBody
    public ResponseEntity<EngineDto> update(@RequestBody @Valid EngineDto engineDto) {
        LOG.info("update with parameters: engineDto={}", engineDto);

        Engine engine = EngineMapper.dtoToEntity(engineDto);
        Engine responseEntity = engineService.update(engine);
        EngineDto response = EngineMapper.entityToDto(responseEntity);
        return ResponseEntity.ok().body(response);
    }
}
