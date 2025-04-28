package com.example.demo.dto.ocpp.schema.reserve_now_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ReserveNowRequest {


    @Min(0)
    /** Id of reservation. */
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    /** Date and time at which the reservation expires. */
    @JsonProperty("expiryDateTime")
    private String expiryDateTime;


    @Size(max = 20)
    /** This field specifies the connector type. Values defined in Appendix as ConnectorEnumStringType. */
    @JsonProperty("connectorType")
    private String connectorType;


    @JsonProperty("idToken")
    private IdToken idToken;


    @Min(0)
    /** This contains ID of the evse to be reserved. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    @JsonProperty("groupIdToken")
    private IdToken groupIdToken;


    @JsonProperty("customData")
    private CustomData customData;

}
