package com.example.demo.dto.ocpp.schema.get_tariffs_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class TariffAssignment {


    @Size(max = 60)
    /** Tariff id. */
    @JsonProperty("tariffId")
    private String tariffId;


    @JsonProperty("tariffKind")
    private TariffKindEnum tariffKind;


    /** Date/time when this tariff become active. */
    @JsonProperty("validFrom")
    private String validFrom;


    @ElementCollection
    @Size(min = 1)
    @JsonProperty("evseIds")
    private List<Integer> evseIds;

    @JsonProperty("evseIds")
    private List<Integer> evseIds = new ArrayList<>();


    @ElementCollection
    @Size(min = 1)
    /** IdTokens related to tariff */
    @JsonProperty("idTokens")
    private List<String> idTokens;

    @JsonProperty("idTokens")
    private List<String> idTokens = new ArrayList<>();


    @JsonProperty("customData")
    private CustomData customData;

}
