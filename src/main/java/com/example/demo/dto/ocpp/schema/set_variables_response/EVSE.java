package com.example.demo.dto.ocpp.schema.set_variables_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class EVSE {


    @Min(0)
    /** EVSE Identifier. This contains a number (&gt; 0) designating an EVSE of the Charging Station. */
    @JsonProperty("id")
    private Integer id;

    @Min(0.0)

    @Min(0)
    /** An id to designate a specific connector (on an EVSE) by connector index number. */
    @JsonProperty("connectorId")
    private Integer connectorId;

    @Min(0.0)

    @JsonProperty("customData")
    private CustomData customData;

}
