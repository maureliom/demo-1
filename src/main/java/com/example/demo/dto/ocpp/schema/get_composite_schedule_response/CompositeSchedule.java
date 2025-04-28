package com.example.demo.dto.ocpp.schema.get_composite_schedule_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CompositeSchedule {


    @Min(0)
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("duration")
    private Integer duration;


    @JsonProperty("scheduleStart")
    private String scheduleStart;


    @JsonProperty("chargingRateUnit")
    private ChargingRateUnitEnum chargingRateUnit;


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("chargingSchedulePeriod")
    private List<ChargingSchedulePeriod> chargingSchedulePeriod;

    @JsonProperty("chargingSchedulePeriod")
    private List<ChargingSchedulePeriod> chargingSchedulePeriod = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
