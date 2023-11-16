package org.cleidson.controller;

import org.cleidson.controller.dto.ShieldDto;
import org.cleidson.service.ShieldService;
import org.cleidson.service.entity.Shield;
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
public class ShieldControllerTest {

    private ShieldController victim;

    @Mock
    private ShieldService shieldService;

    @BeforeEach
    public void before() {
        this.victim = new ShieldController(shieldService);
    }

    @Test
    void shouldUpdateShieldToDisabled() {
        Shield shield = new Shield();
        shield.setId(1L);
        shield.setPowerStatus(Boolean.TRUE);
        shield.setPowerConsumption(1000);
        shield.setCapacity(5000);
        Mockito.when(shieldService.update(Mockito.any())).thenReturn(shield);

        ShieldDto shieldDto = new ShieldDto(Boolean.TRUE, 1000, 5000);
        ResponseEntity<ShieldDto> obtained = victim.update(shieldDto);

        Mockito.verify(shieldService).update(Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, obtained.getStatusCode());
        Assertions.assertNotNull(obtained.getBody());
        assertShieldDto(obtained.getBody());
    }

    private void assertShieldDto(ShieldDto obtained) {
        ShieldDto expected = new ShieldDto(Boolean.TRUE, 1000, 5000);
        Assertions.assertEquals(expected.powerStatus(), obtained.powerStatus());
        Assertions.assertEquals(expected.powerConsumption(), obtained.powerConsumption());
        Assertions.assertEquals(expected.capacity(), obtained.capacity());
    }

}
