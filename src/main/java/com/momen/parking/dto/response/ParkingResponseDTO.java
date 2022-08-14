package com.momen.parking.dto.response;

import com.momen.parking.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ParkingResponseDTO extends BaseDTO {
    @ApiModelProperty(hidden = true)
    private Date entryTime;

    @ApiModelProperty(hidden = true)
    private Date exitTime;

    @ApiModelProperty(required = true)
    private VehicleResponseDTO vehicle;

    @ApiModelProperty(hidden = true)
    private PriceRateResponseDTO priceRate;

    @ApiModelProperty(hidden = true)
    private Long totalPrice;

    @ApiModelProperty(hidden = true)
    private Boolean isPaid;
}
