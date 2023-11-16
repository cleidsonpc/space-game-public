package org.cleidson.controller;

import org.cleidson.controller.dto.PowerPlantDto;
import org.cleidson.service.PowerPlantService;
import org.cleidson.service.entity.PowerPlant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PowerPlantControllerTest {

    private PowerPlantController victim;

    @Mock
    private PowerPlantService powerPlantService;

    @BeforeEach
    public void before() {
        this.victim = new PowerPlantController(powerPlantService);
    }

    @Test
    void shouldUpdatePowerPlantToDisabled() {
        PowerPlant powerPlant = new PowerPlant();
        powerPlant.setId(1L);
        powerPlant.setPowerStatus(Boolean.TRUE);
        powerPlant.setEnergyAvailable(5000);
        Mockito.when(powerPlantService.update(Mockito.any())).thenReturn(powerPlant);

        PowerPlantDto powerPlantDto = new PowerPlantDto(Boolean.TRUE, 100);
        ResponseEntity<PowerPlantDto> obtained = victim.update(powerPlantDto);

        Mockito.verify(powerPlantService).update(Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, obtained.getStatusCode());
        Assertions.assertNotNull(obtained.getBody());
        assertPowerPlantDto(obtained.getBody());
    }

    private void assertPowerPlantDto(PowerPlantDto obtained) {
        PowerPlantDto expected = new PowerPlantDto(Boolean.TRUE, 5000);
        Assertions.assertEquals(expected.powerStatus(), obtained.powerStatus());
        Assertions.assertEquals(expected.energyAvailable(), obtained.energyAvailable());
    }
}
