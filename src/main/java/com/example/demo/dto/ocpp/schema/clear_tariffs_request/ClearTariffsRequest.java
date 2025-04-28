package com.example.demo.dto.ocpp.schema.clear_tariffs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearTariffsRequest {


    @ElementCollection
    @Size(min = 1)
    /** List of tariff Ids to clear. When absent clears all tariffs at _evseId_. */
    @JsonProperty("tariffIds")
    private List<String> tariffIds;

    @JsonProperty("tariffIds")
    private List<String> tariffIds = new ArrayList<>();


    @Min(0)
    /** When present only clear tariffs matching _tariffIds_ at EVSE _evseId_. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
