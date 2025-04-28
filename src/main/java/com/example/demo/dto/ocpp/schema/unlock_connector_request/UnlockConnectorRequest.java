package com.example.demo.dto.ocpp.schema.unlock_connector_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class UnlockConnectorRequest {


    @Min(0)
    /** This contains the identifier of the EVSE for which a connector needs to be unlocked. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @Min(0)
    /** This contains the identifier of the connector that needs to be unlocked. */
    @JsonProperty("connectorId")
    private Integer connectorId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
