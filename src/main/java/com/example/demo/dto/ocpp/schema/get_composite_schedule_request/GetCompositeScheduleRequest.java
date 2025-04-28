package com.example.demo.dto.ocpp.schema.get_composite_schedule_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetCompositeScheduleRequest {


    /** Length of the requested schedule in seconds. */
    @JsonProperty("duration")
    private Integer duration;


    @JsonProperty("chargingRateUnit")
    private ChargingRateUnitEnum chargingRateUnit;


    @Min(0)
    /** The ID of the EVSE for which the schedule is requested. When evseid=0, the Charging Station will calculate the expected consumption for the grid connection. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
