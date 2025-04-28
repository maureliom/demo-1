package com.example.demo.dto.ocpp.schema.unpublish_firmware_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class UnpublishFirmwareRequest {


    @Size(max = 32)
    /** The MD5 checksum over the entire firmware file as a hexadecimal string of length 32. */
    @JsonProperty("checksum")
    private String checksum;


    @JsonProperty("customData")
    private CustomData customData;

}
