package org.cleidson.controller;

import org.cleidson.controller.dto.EngineDto;
import org.cleidson.controller.dto.PowerPlantDto;
import org.cleidson.controller.dto.ShieldDto;
import org.cleidson.controller.dto.ShipStatusDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class ShipStatusController {

    private static final Logger LOG = LoggerFactory.getLogger(ShipStatusController.class);

    private static final String URL_SHIP_STATUS = "/ship_status";

    @RequestMapping(URL_SHIP_STATUS)
    @ResponseBody
    public ResponseEntity<ShipStatusDto> getShipStatus() {
        LOG.info("getShipStatus performed.");

        PowerPlantDto powerPlantDto = new PowerPlantDto(Boolean.TRUE, 1000);
        EngineDto engineDto = new EngineDto(Boolean.TRUE, 200);
        ShieldDto shieldDto = new ShieldDto(Boolean.TRUE, 200, 500);

        ShipStatusDto shipStatusDto = new ShipStatusDto(powerPlantDto, engineDto, shieldDto);

        return ResponseEntity.ok().body(shipStatusDto);
    }

}
