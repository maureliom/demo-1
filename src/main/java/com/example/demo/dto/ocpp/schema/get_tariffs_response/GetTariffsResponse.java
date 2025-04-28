package com.example.demo.dto.ocpp.schema.get_tariffs_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetTariffsResponse {


    @JsonProperty("status")
    private TariffGetStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("tariffAssignments")
    private List<TariffAssignment> tariffAssignments;

    @JsonProperty("tariffAssignments")
    private List<TariffAssignment> tariffAssignments = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
