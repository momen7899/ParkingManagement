package com.momen.parking.dto.request;

import com.momen.parking.common.BaseDTO;
import lombok.Data;

@Data
public class PriceRateRequestDTO extends BaseDTO {
    private Long entry;
    private Long hourly;
    private Long daily;
    private Long monthly;
}
