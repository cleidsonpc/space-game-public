package org.cleidson.service;


import org.cleidson.service.entity.Shield;
import org.cleidson.service.repository.ShieldRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ShieldServiceTest {

    // TODO: 09/08/2023 refactor to unit test

    ShieldService victim;

    @Mock
    private ShieldRepository shieldRepository;

    @BeforeEach
    public void beforeEach() {
        victim = new ShieldService(shieldRepository);
    }

    @Test
    void shouldCreateShieldData() {
        Shield shieldExpected = buildShieldExpected();
        Mockito.when(shieldRepository.save(shieldExpected)).thenReturn(shieldExpected);

        Shield shieldObtained = victim.create(shieldExpected);

        assertShield(shieldExpected, shieldObtained);
    }

    @Test
    void shouldGetAllShieldsData() {
        Shield shieldExpected = buildShieldExpected();
        Mockito.when(shieldRepository.findById(1L)).thenReturn(Optional.of(shieldExpected));

        Shield shieldObtained = victim.get();
        assertShield(shieldExpected, shieldObtained);
    }

    @Test
    void shouldUpdateShieldData() {
        Shield shieldExpected = buildShieldExpected();
        Mockito.when(shieldRepository.findById(1L)).thenReturn(Optional.of(shieldExpected));
        Mockito.when(shieldRepository.save(shieldExpected)).thenReturn(shieldExpected);

        Shield shieldObtained = victim.update(shieldExpected);
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
