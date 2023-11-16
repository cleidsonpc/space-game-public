package org.cleidson.mapper;

import org.cleidson.controller.dto.ShieldDto;
import org.cleidson.service.entity.Shield;

public class ShieldMapper {

    public static Shield dtoToEntity(ShieldDto shieldDto) {
        Shield shield = new Shield();
        shield.setId(1L);
        shield.setPowerStatus(shieldDto.powerStatus());
        shield.setPowerConsumption(shieldDto.powerConsumption());
        shield.setCapacity(shieldDto.capacity());
        return shield;
    }

    public static ShieldDto entityToDto(Shield shield) {
        return new ShieldDto(
                shield.getPowerStatus(),
                shield.getPowerConsumption(),
                shield.getCapacity());
    }

}
