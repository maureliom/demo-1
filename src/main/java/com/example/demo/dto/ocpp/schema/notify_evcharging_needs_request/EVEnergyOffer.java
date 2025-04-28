package com.example.demo.dto.ocpp.schema.notify_evcharging_needs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EVEnergyOffer {


    @JsonProperty("evAbsolutePriceSchedule")
    private EVAbsolutePriceSchedule evAbsolutePriceSchedule;


    @JsonProperty("evPowerSchedule")
    private EVPowerSchedule evPowerSchedule;


    @JsonProperty("customData")
    private CustomData customData;

}
