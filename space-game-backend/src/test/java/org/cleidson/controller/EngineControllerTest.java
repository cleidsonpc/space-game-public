package org.cleidson.controller;

import org.cleidson.controller.dto.EngineDto;
import org.cleidson.service.EngineService;
import org.cleidson.service.entity.Engine;
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
public class EngineControllerTest {

    private EngineController victim;

    @Mock
    private EngineService engineService;

    @BeforeEach
    public void before() {
        this.victim = new EngineController(engineService);
    }

    @Test
    void shouldUpdatePowerPlantToDisabled() {
        Engine engine = new Engine();
        engine.setId(1L);
        engine.setPowerStatus(Boolean.TRUE);
        engine.setPowerConsumption(1000);
        Mockito.when(engineService.update(Mockito.any())).thenReturn(engine);

        EngineDto engineDto = new EngineDto(Boolean.TRUE, 1000);
        ResponseEntity<EngineDto> obtained = victim.update(engineDto);

        Mockito.verify(engineService).update(Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, obtained.getStatusCode());
        Assertions.assertNotNull(obtained.getBody());
        assertPowerPlantDto(obtained.getBody());
    }

    private void assertPowerPlantDto(EngineDto obtained) {
        EngineDto expected = new EngineDto(Boolean.TRUE, 1000);
        Assertions.assertEquals(expected.powerStatus(), obtained.powerStatus());
        Assertions.assertEquals(expected.powerConsumption(), obtained.powerConsumption());
    }
}
