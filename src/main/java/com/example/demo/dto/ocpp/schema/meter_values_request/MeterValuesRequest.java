package com.example.demo.dto.ocpp.schema.meter_values_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class MeterValuesRequest {


    @Min(0)
    /** This contains a number (&gt;0) designating an EVSE of the Charging Station. ‘0’ (zero) is used to designate the main power meter. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @ElementCollection
    @Size(min = 1)
    @JsonProperty("meterValue")
    private List<MeterValue> meterValue;

    @JsonProperty("meterValue")
    private List<MeterValue> meterValue = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
