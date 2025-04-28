package com.example.demo.dto.ocpp.schema.set_default_tariff_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class SetDefaultTariffRequest {


    @Min(0)
    /** EVSE that tariff applies to. When _evseId_ = 0, then tarriff applies to all EVSEs. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("tariff")
    private Tariff tariff;


    @JsonProperty("customData")
    private CustomData customData;

}
