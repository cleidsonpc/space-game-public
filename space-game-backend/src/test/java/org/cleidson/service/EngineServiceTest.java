package org.cleidson.service;

import org.cleidson.service.entity.Engine;
import org.cleidson.service.repository.EngineRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EngineServiceTest {

    private EngineService victim;

    @Mock
    private EngineRepository engineRepository;

    @BeforeEach
    public void beforeEach() {
        victim = new EngineService(engineRepository);
    }

    @Test
    void shouldCreateEngine() {
        Engine engineExpected = buildEngineExpected();
        Mockito.when(engineRepository.save(engineExpected)).thenReturn(engineExpected);

        Engine engineObtained = victim.create(engineExpected);
        assertEngine(engineExpected, engineObtained);
    }

    @Test
    void shouldGetEngineData() {
        Engine engineExpected = buildEngineExpected();
        Mockito.when(engineRepository.findById(1L)).thenReturn(Optional.of(engineExpected));

        Engine engineObtained = victim.get();
        assertEngine(engineExpected, engineObtained);
    }

    @Test
    void shouldUpdateEngineData() {
        Engine engineExpected = buildEngineExpected();
        Mockito.when(engineRepository.findById(1L)).thenReturn(Optional.of(engineExpected));
        Mockito.when(engineRepository.save(engineExpected)).thenReturn(engineExpected);

        Engine engineObtained = victim.update(engineExpected);
        assertEngine(engineExpected, engineObtained);
    }

    private Engine buildEngineExpected() {
        Engine engineExpected = new Engine();
        engineExpected.setId(1L);
        engineExpected.setPowerStatus(Boolean.TRUE);
        engineExpected.setPowerConsumption(5000);
        return engineExpected;
    }

    private void assertEngine(Engine engineExpected, Engine engineObtained) {
        Assertions.assertEquals(engineExpected.getId(), engineObtained.getId());
        Assertions.assertEquals(engineExpected.getPowerStatus(), engineObtained.getPowerStatus());
        Assertions.assertEquals(engineExpected.getPowerConsumption(), engineObtained.getPowerConsumption());
    }
}
