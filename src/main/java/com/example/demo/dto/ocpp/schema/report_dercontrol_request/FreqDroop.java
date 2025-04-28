package com.example.demo.dto.ocpp.schema.report_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class FreqDroop {


    @Min(0)
    /** Priority of setting (0=highest) */
    @JsonProperty("priority")
    private Integer priority;

    @Min(0.0)

    /** Over-frequency start of droop */
    @JsonProperty("overFreq")
    private Double overFreq;


    /** Under-frequency start of droop */
    @JsonProperty("underFreq")
    private Double underFreq;


    /** Over-frequency droop per unit, oFDroop */
    @JsonProperty("overDroop")
    private Double overDroop;


    /** Under-frequency droop per unit, uFDroop */
    @JsonProperty("underDroop")
    private Double underDroop;


    /** Open loop response time in seconds */
    @JsonProperty("responseTime")
    private Double responseTime;


    /** Time when this setting becomes active */
    @JsonProperty("startTime")
    private String startTime;


    /** Duration in seconds that this setting is active */
    @JsonProperty("duration")
    private Double duration;


    @JsonProperty("customData")
    private CustomData customData;

}
