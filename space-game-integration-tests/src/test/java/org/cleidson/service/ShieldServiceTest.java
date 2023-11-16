package org.cleidson.service;


import org.cleidson.service.ShieldService;
import org.cleidson.service.entity.Shield;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShieldServiceTest {

    final ShieldService shieldService;

    @LocalServerPort
    private int port;

    @Autowired
    public ShieldServiceTest(ShieldService shieldService) {
        this.shieldService = shieldService;
    }

    @Test
    void shouldCreateShieldData() {
        Shield shieldExpected = buildShieldExpected();
        Shield shieldObtained = shieldService.update(shieldExpected);
        assertShield(shieldExpected,shieldObtained);
    }

    @Test
    void shouldGetAllShieldsData() {
        Shield shieldExpected = buildShieldExpected();
        Shield shieldObtained = shieldService.get();
        assertShield(shieldExpected, shieldObtained);
    }

    @Test
    void shouldUpdateShieldData() {
        Shield shieldExpected = buildShieldExpected();
        Shield shieldObtained = shieldService.update(shieldExpected);
        assertShield(shieldExpected, shieldObtained);
    }

    private Shield buildShieldExpected() {
        Shield shieldExpected = new Shield();
        shieldExpected.setId(1L);
        shieldExpected.setPowerStatus(Boolean.TRUE);
        shieldExpected.setPowerConsumption(1000);
        shieldExpected.setCapacity(500);
        return shieldExpected;
    }

    private void assertShield(Shield shieldExpected, Shield shieldObtained) {
        Assertions.assertEquals(shieldExpected.getId(), shieldObtained.getId());
        Assertions.assertEquals(shieldExpected.getPowerStatus(), shieldObtained.getPowerStatus());
        Assertions.assertEquals(shieldExpected.getPowerConsumption(), shieldObtained.getPowerConsumption());
        Assertions.assertEquals(shieldExpected.getCapacity(), shieldObtained.getCapacity());
    }
}
