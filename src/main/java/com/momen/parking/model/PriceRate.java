package com.momen.parking.model;

import com.momen.parking.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class PriceRate extends BaseEntity {
    private Long entry;
    private Long hourly;
    private Long daily;
    private Long monthly;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "priceRate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Parking> parkingList;
}
