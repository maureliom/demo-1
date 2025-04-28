package com.example.demo.dto.ocpp.schema.report_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class LimitMaxDischargeGet {


    @Size(max = 36)
    /** Id of setting */
    @JsonProperty("id")
    private String id;


    /** True if setting is a default control. */
    @JsonProperty("isDefault")
    private Boolean isDefault;


    /** True if this setting is superseded by a higher priority setting (i.e. lower value of _priority_) */
    @JsonProperty("isSuperseded")
    private Boolean isSuperseded;


    @JsonProperty("limitMaxDischarge")
    private LimitMaxDischarge limitMaxDischarge;


    @JsonProperty("customData")
    private CustomData customData;

}
