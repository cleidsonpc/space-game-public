package org.cleidson.service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SHIELD")
public class Shield {

    @Column
    Boolean powerStatus;
    @Column
    Integer powerConsumption;
    @Column
    Integer capacity;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    // TODO: 07/08/2023 Add ship relationship.

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
