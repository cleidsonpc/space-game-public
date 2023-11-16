package org.cleidson.mapper;

import org.cleidson.controller.dto.PowerPlantDto;
import org.cleidson.service.entity.PowerPlant;

public class PowerPlantMapper {

    public static PowerPlant dtoToEntity(PowerPlantDto powerPlantDto) {
        PowerPlant powerPlant = new PowerPlant();
        powerPlant.setPowerStatus(powerPlantDto.powerStatus());
        powerPlant.setEnergyAvailable(powerPlantDto.energyAvailable());
        return powerPlant;
    }

    public static PowerPlantDto entityToDto(PowerPlant powerPlant) {
        return new PowerPlantDto(powerPlant.getPowerStatus(), powerPlant.getEnergyAvailable());
    }

}
