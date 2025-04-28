package com.example.demo.dto.ocpp.schema.get_dercontrol_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetDERControlRequest {


    /** RequestId to be used in ReportDERControlRequest. */
    @JsonProperty("requestId")
    private Integer requestId;


    /** True: get a default DER control. False: get a scheduled control. */
    @JsonProperty("isDefault")
    private Boolean isDefault;


    @JsonProperty("controlType")
    private DERControlEnum controlType;


    @Size(max = 36)
    /** Id of setting to get. When omitted all settings for _controlType_ are retrieved. */
    @JsonProperty("controlId")
    private String controlId;


    @JsonProperty("customData")
    private CustomData customData;

}
