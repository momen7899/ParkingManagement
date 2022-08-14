package com.momen.parking.dto.request;

import com.momen.parking.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ParkingRequestDTO extends BaseDTO {
    @ApiModelProperty(hidden = true)
    private Date entryTime;

    @ApiModelProperty(hidden = true)
    private Date exitTime;

    @ApiModelProperty(required = true)
    private VehicleRequestDTO vehicle;

    @ApiModelProperty(hidden = true)
    private PriceRateRequestDTO priceRate;
}
