package com.example.demo.dto.ocpp.schema.set_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ReactivePowerParams {


    /** Only for VoltVar curve: The nominal ac voltage (rms) adjustment to the voltage curve points for Volt-Var curves (percentage). */
    @JsonProperty("vRef")
    private Double vRef;


    /** Only for VoltVar: Enable/disable autonomous VRef adjustment */
    @JsonProperty("autonomousVRefEnable")
    private Boolean autonomousVRefEnable;


    /** Only for VoltVar: Adjustment range for VRef time constant */
    @JsonProperty("autonomousVRefTimeConstant")
    private Double autonomousVRefTimeConstant;


    @JsonProperty("customData")
    private CustomData customData;

}
