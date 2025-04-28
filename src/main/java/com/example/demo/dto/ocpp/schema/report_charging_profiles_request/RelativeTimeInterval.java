package com.example.demo.dto.ocpp.schema.report_charging_profiles_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class RelativeTimeInterval {


    /** Start of the interval, in seconds from NOW. */
    @JsonProperty("start")
    private Integer start;


    /** Duration of the interval, in seconds. */
    @JsonProperty("duration")
    private Integer duration;


    @JsonProperty("customData")
    private CustomData customData;

}
