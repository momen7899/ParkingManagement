package com.momen.parking.model;

import com.momen.parking.common.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Vehicle extends BaseEntity {
    private VehicleType carType;
    @Column(unique = true)
    private String plaque;
}
