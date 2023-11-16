package org.cleidson.mapper;

import org.cleidson.controller.dto.EngineDto;
import org.cleidson.service.entity.Engine;

public class EngineMapper {

    public static Engine dtoToEntity(EngineDto engineDto) {
        Engine engine = new Engine();
        engine.setPowerStatus(engineDto.powerStatus());
        engine.setPowerConsumption(engineDto.powerConsumption());
        return engine;
    }

    public static EngineDto entityToDto(Engine engine) {
        return new EngineDto(engine.getPowerStatus(), engine.getPowerConsumption());
    }

}
