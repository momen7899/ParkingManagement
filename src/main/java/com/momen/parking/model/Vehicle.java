package com.momen.parking.model;

import com.momen.parking.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Vehicle extends BaseEntity {
    @Enumerated(value = EnumType.STRING)
    private VehicleType vehicleType;

    @Column(unique = true)
    private String plaque;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Parking> parkingList;
}
