package org.cleidson.service.entity;

import jakarta.persistence.*;

// TODO: 08/08/2023 Rename to "thrusters".

@Entity
@Table(name = "ENGINE")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Boolean powerStatus;

    @Column
    private Integer powerConsumption;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(Boolean powerStatus) {
        this.powerStatus = powerStatus;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}
