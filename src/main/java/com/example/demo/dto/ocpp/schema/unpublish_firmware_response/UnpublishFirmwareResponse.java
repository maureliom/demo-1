package com.example.demo.dto.ocpp.schema.unpublish_firmware_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class UnpublishFirmwareResponse {


    @JsonProperty("status")
    private UnpublishFirmwareStatusEnum status;


    @JsonProperty("customData")
    private CustomData customData;

}
