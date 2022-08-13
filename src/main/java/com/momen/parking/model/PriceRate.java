package com.momen.parking.model;

import com.momen.parking.common.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class PriceRate extends BaseEntity {
    private Long entry;
    private Long hourly;
    private Long daily;
    private Long monthly;
}
