package org.cleidson.service;


import org.cleidson.service.EngineService;
import org.cleidson.service.entity.Engine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class EngineServiceTest {

    final EngineService victim;

    @Autowired
    public EngineServiceTest(EngineService engineService) {
        this.victim = engineService;
    }

    @Test
    void shouldCreateEngine() {
        Engine engineExpected = buildEngineExpected();
        Engine engineObtained = victim.create(engineExpected);
        assertEngine(engineExpected, engineObtained);
    }

    @Test
    void shouldGetEngineData() {
        Engine engineExpected = buildEngineExpected();
        Engine engineObtained = victim.get();
        assertEngine(engineExpected, engineObtained);
    }

    @Test
    void shouldUpdateEngineData() {
        Engine engineExpected = buildEngineExpected();
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
