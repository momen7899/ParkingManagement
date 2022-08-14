package com.momen.parking.model;


import com.momen.parking.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Parking extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    private Date entryTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date exitTime;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "price_id")
    private PriceRate priceRate;

    private Long totalPrice;
    private Boolean isPaid;

}
