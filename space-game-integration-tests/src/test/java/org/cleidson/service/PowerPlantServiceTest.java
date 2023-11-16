package org.cleidson.service;


import org.cleidson.service.PowerPlantService;
import org.cleidson.service.entity.PowerPlant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class PowerPlantServiceTest {

    final PowerPlantService victim;

    @Autowired
    public PowerPlantServiceTest(PowerPlantService powerPlantService) {
        this.victim = powerPlantService;
    }

    @Test
    void shouldCreatePowerPlant() {
        PowerPlant powerPlantExpected = buildPowerPlantExpected();
        PowerPlant powerPlantObtained = victim.create(powerPlantExpected);
        assertPowerPlant(powerPlantExpected, powerPlantObtained);
    }

    @Test
    void shouldGetPowerPlantData() {
        PowerPlant powerPlantExpected = buildPowerPlantExpected();
        PowerPlant powerPlantObtained = victim.get();
        assertPowerPlant(powerPlantExpected, powerPlantObtained);
    }

    @Test
    void shouldUpdatePowerPlantData() {
        PowerPlant powerPlantExpected = buildPowerPlantExpected();
        PowerPlant powerPlantObtained = victim.update(powerPlantExpected);
        assertPowerPlant(powerPlantExpected, powerPlantObtained);
    }

    private PowerPlant buildPowerPlantExpected() {
        PowerPlant powerPlantExpected = new PowerPlant();
        powerPlantExpected.setId(1L);
        powerPlantExpected.setPowerStatus(Boolean.TRUE);
        powerPlantExpected.setEnergyAvailable(5000);
        return powerPlantExpected;
    }

    private void assertPowerPlant(PowerPlant powerPlantExpected, PowerPlant powerPlantObtained) {
        Assertions.assertEquals(powerPlantExpected.getId(), powerPlantObtained.getId());
        Assertions.assertEquals(powerPlantExpected.getPowerStatus(), powerPlantObtained.getPowerStatus());
        Assertions.assertEquals(powerPlantExpected.getEnergyAvailable(), powerPlantObtained.getEnergyAvailable());
    }
}
