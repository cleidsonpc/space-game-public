package org.cleidson.service;

import org.cleidson.service.entity.PowerPlant;
import org.cleidson.service.repository.PowerPlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PowerPlantService implements ServiceInterface<PowerPlant> {

    private final PowerPlantRepository powerPlantRepository;

    @Autowired
    public PowerPlantService(PowerPlantRepository powerPlantRepository) {
        this.powerPlantRepository = powerPlantRepository;
    }

    @Override
    public PowerPlant get() {
        Optional<PowerPlant> powerPlantEntityOptional = powerPlantRepository.findById(1L);
        return powerPlantEntityOptional.orElse(null);
    }

    @Override
    public PowerPlant create(PowerPlant entity) {
        return powerPlantRepository.save(entity);
    }

    @Override
    public PowerPlant update(PowerPlant entity) {

        Optional<PowerPlant> powerPlantEntityObtained = powerPlantRepository.findById(1L);

        PowerPlant result = null;

        if (powerPlantEntityObtained.isPresent()) {
            PowerPlant powerPlant = powerPlantEntityObtained.get();

            powerPlant.setPowerStatus(entity.getPowerStatus());
            powerPlant.setEnergyAvailable(entity.getEnergyAvailable());

            result = powerPlantRepository.save(powerPlant);
        }

        return result;
    }


}
