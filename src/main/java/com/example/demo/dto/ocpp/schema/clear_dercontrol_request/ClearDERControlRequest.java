package com.example.demo.dto.ocpp.schema.clear_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ClearDERControlRequest {


    /** True: clearing default DER controls. False: clearing scheduled controls. */
    @JsonProperty("isDefault")
    private Boolean isDefault;


    @JsonProperty("controlType")
    private DERControlEnum controlType;


    @Size(max = 36)
    /** Id of control setting to clear. When omitted all settings for _controlType_ are cleared. */
    @JsonProperty("controlId")
    private String controlId;


    @JsonProperty("customData")
    private CustomData customData;

}
