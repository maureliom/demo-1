package com.example.demo.dto.ocpp.schema.clear_tariffs_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearTariffsResult {


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    @Size(max = 60)
    /** Id of tariff for which _status_ is reported. If no tariffs were found, then this field is absent, and _status_ will be `NoTariff`. */
    @JsonProperty("tariffId")
    private String tariffId;


    @JsonProperty("status")
    private TariffClearStatusEnum status;


    @JsonProperty("customData")
    private CustomData customData;

}
