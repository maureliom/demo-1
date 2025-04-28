package com.example.demo.dto.ocpp.schema.get_tariffs_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetTariffsRequest {


    @Min(0)
    /** EVSE id to get tariff from. When _evseId_ = 0, this gets tariffs from all EVSEs. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
