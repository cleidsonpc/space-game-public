package org.cleidson.service;


import org.cleidson.service.entity.PowerPlant;
import org.cleidson.service.repository.PowerPlantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PowerPlantServiceTest {

    // TODO: 09/08/2023 refactor to unit test

    private PowerPlantService victim;

    @Mock
    private PowerPlantRepository powerPlantRepository;

    @BeforeEach
    public void beforeEach() {
        victim = new PowerPlantService(powerPlantRepository);
    }

    @Test
    void shouldCreatePowerPlant() {
        PowerPlant powerPlantExpected = buildPowerPlantExpected();
        Mockito.when(powerPlantRepository.save(powerPlantExpected)).thenReturn(powerPlantExpected);

        PowerPlant powerPlantObtained = victim.create(powerPlantExpected);
        assertPowerPlant(powerPlantExpected, powerPlantObtained);
    }

    @Test
    void shouldGetPowerPlantData() {
        PowerPlant powerPlantExpected = buildPowerPlantExpected();

        Mockito.when(powerPlantRepository.findById(1L)).thenReturn(Optional.of(powerPlantExpected));

        PowerPlant powerPlantObtained = victim.get();
        assertPowerPlant(powerPlantExpected, powerPlantObtained);
    }

    @Test
    void shouldUpdatePowerPlantData() {
        PowerPlant powerPlantExpected = buildPowerPlantExpected();
        Mockito.when(powerPlantRepository.findById(1L)).thenReturn(Optional.of(powerPlantExpected));
        Mockito.when(powerPlantRepository.save(powerPlantExpected)).thenReturn(powerPlantExpected);

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
