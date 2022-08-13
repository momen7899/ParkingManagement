package com.momen.parking.dto.request;

import com.momen.parking.common.BaseDTO;
import com.momen.parking.model.VehicleType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VehicleRequestDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private VehicleType carType;

    @ApiModelProperty(required = true, hidden = false)
    private String plaque;
}
