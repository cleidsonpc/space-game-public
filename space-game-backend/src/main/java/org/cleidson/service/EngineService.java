package org.cleidson.service;

import org.cleidson.service.entity.Engine;
import org.cleidson.service.repository.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EngineService implements ServiceInterface<Engine> {

    private final EngineRepository engineRepository;

    @Autowired
    public EngineService(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public Engine get() {
        Optional<Engine> engineOptional = engineRepository.findById(1L);
        return engineOptional.orElse(null);
    }

    @Override
    public Engine create(Engine entity) {
        return engineRepository.save(entity);
    }

    @Override
    public Engine update(Engine entity) {

        Optional<Engine> engineObtained = engineRepository.findById(1L);

        Engine result = null;

        if (engineObtained.isPresent()) {
            Engine engine = engineObtained.get();

            engine.setPowerStatus(entity.getPowerStatus());
            engine.setPowerConsumption(entity.getPowerConsumption());

            result = engineRepository.save(engine);
        }

        return result;
    }


}
