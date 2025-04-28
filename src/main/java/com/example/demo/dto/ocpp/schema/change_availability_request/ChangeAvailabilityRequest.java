package com.example.demo.dto.ocpp.schema.change_availability_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChangeAvailabilityRequest {


    @JsonProperty("evse")
    private EVSE evse;


    @JsonProperty("operationalStatus")
    private OperationalStatusEnum operationalStatus;


    @JsonProperty("customData")
    private CustomData customData;

}
