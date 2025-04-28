package com.example.demo.dto.ocpp.schema.reset_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ResetRequest {


    @JsonProperty("type")
    private ResetEnum type;


    @Min(0)
    /** This contains the ID of a specific EVSE that needs to be reset, instead of the entire Charging Station. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
