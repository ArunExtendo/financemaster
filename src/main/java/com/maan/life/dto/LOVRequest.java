package com.maan.life.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LOVRequest {

    @NotNull(message = "App Code Type / App Param code is required")
    private String param;

    private String subParam;


}
