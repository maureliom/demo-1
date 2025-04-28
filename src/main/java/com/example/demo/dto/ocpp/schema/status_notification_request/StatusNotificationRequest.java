package com.example.demo.dto.ocpp.schema.status_notification_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class StatusNotificationRequest {


    /** The time for which the status is reported. */
    @JsonProperty("timestamp")
    private String timestamp;


    @JsonProperty("connectorStatus")
    private ConnectorStatusEnum connectorStatus;


    @Min(0)
    /** The id of the EVSE to which the connector belongs for which the the status is reported. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @Min(0)
    /** The id of the connector within the EVSE for which the status is reported. */
    @JsonProperty("connectorId")
    private Integer connectorId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
