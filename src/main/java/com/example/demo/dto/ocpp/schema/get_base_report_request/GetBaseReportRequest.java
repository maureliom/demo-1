package com.example.demo.dto.ocpp.schema.get_base_report_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetBaseReportRequest {


    /** The Id of the request. */
    @JsonProperty("requestId")
    private Integer requestId;


    @JsonProperty("reportBase")
    private ReportBaseEnum reportBase;


    @JsonProperty("customData")
    private CustomData customData;

}
