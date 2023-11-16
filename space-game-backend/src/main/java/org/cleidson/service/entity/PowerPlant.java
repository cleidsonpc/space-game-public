package org.cleidson.service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "POWER_PLANT")
public class PowerPlant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Boolean powerStatus;

    @Column
    private Integer energyAvailable;

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

    public Integer getEnergyAvailable() {
        return energyAvailable;
    }

    public void setEnergyAvailable(Integer energyAvailable) {
        this.energyAvailable = energyAvailable;
    }
}
