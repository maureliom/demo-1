package com.example.demo.dto.ocpp.schema.data_transfer_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class DataTransferResponse {


    @JsonProperty("status")
    private DataTransferStatusEnum status;


    @JsonProperty("statusInfo")
    private StatusInfo statusInfo;


    /** Data without specified length or format, in response to request. */
    @JsonProperty("data")
    private String data;


    @JsonProperty("customData")
    private CustomData customData;

}
