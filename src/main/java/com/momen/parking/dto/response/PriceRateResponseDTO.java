package com.momen.parking.dto.response;

import com.momen.parking.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PriceRateResponseDTO extends BaseDTO {
    @ApiModelProperty(hidden = true)
    private Long entry;
    @ApiModelProperty(hidden = true)
    private Long hourly;
    @ApiModelProperty(hidden = true)
    private Long daily;
    @ApiModelProperty(hidden = true)
    private Long monthly;
}
