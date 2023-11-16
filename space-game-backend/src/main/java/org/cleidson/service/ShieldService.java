package org.cleidson.service;

import org.cleidson.service.entity.Shield;
import org.cleidson.service.repository.ShieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShieldService implements ServiceInterface<Shield> {

    private final ShieldRepository shieldRepository;

    @Autowired
    public ShieldService(ShieldRepository shieldRepository) {
        this.shieldRepository = shieldRepository;
    }

    @Override
    public Shield get() {
        Optional<Shield> shieldOptional = shieldRepository.findById(1L);
        return shieldOptional.orElse(null);
    }

    @Override
    public Shield create(Shield shield) {
        return shieldRepository.save(shield);
    }

    @Override
    public Shield update(Shield shield) {
        Optional<Shield> shieldEntityOptional = shieldRepository.findById(shield.getId());

        Shield result = null;

        if (shieldEntityOptional.isPresent()) {
            Shield shieldToUpdate = shieldEntityOptional.get();

            shieldToUpdate.setPowerStatus(shield.getPowerStatus());
            shieldToUpdate.setPowerConsumption(shield.getPowerConsumption());
            shieldToUpdate.setCapacity(shield.getCapacity());

            result = shieldRepository.save(shield);
        }

        return result;
    }

}
