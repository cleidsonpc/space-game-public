package org.cleidson.app_database_init;

import org.cleidson.service.PowerPlantService;
import org.cleidson.service.ShieldService;
import org.cleidson.service.entity.PowerPlant;
import org.cleidson.service.entity.Shield;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInit {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseInit.class);

    private final ShieldService shieldService;

    private final PowerPlantService powerPlantService;

    @Autowired
    public DatabaseInit(ShieldService shieldService, PowerPlantService powerPlantService) {
        this.shieldService = shieldService;
        this.powerPlantService = powerPlantService;
    }

    @Bean
    CommandLineRunner initDatabase() {

        return args -> {
            Shield shield = new Shield();
            shield.setPowerStatus(Boolean.TRUE);
            shield.setPowerConsumption(1000);
            shield.setCapacity(5000);
            Shield shieldSaved = shieldService.create(shield);

            PowerPlant powerPlant = new PowerPlant();
            powerPlant.setPowerStatus(Boolean.FALSE);
            powerPlant.setEnergyAvailable(5000);
            PowerPlant powerPlantSaved = powerPlantService.create(powerPlant);

            LOG.info("initDatabase => Shield={}, PowerPlant={}",
                    shieldSaved.toString(),
                    powerPlantSaved.toString());
        };

    }
}
