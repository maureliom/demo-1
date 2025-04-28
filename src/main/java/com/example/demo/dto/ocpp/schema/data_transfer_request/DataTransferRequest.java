package com.example.demo.dto.ocpp.schema.data_transfer_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class DataTransferRequest {


    @Size(max = 50)
    /** May be used to indicate a specific message or implementation. */
    @JsonProperty("messageId")
    private String messageId;


    /** Data without specified length or format. This needs to be decided by both parties (Open to implementation). */
    @JsonProperty("data")
    private String data;


    @Size(max = 255)
    /** This identifies the Vendor specific implementation */
    @JsonProperty("vendorId")
    private String vendorId;


    @JsonProperty("customData")
    private CustomData customData;

}
