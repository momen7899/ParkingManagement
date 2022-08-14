package com.momen.parking.dto.response;

import com.momen.parking.common.BaseDTO;
import com.momen.parking.model.VehicleType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class VehicleResponseDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private VehicleType vehicleType;

    @ApiModelProperty(required = true, hidden = false)
    private String plaque;
}
