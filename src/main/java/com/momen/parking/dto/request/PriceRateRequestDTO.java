package com.momen.parking.dto.request;

import lombok.Data;

@Data
public class PriceRateRequestDTO {
    private Long entry;
    private Long hourly;
    private Long daily;
    private Long monthly;
}
