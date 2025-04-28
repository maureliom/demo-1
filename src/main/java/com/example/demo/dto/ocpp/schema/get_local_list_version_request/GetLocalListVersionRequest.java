package com.example.demo.dto.ocpp.schema.get_local_list_version_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class GetLocalListVersionRequest {


    @JsonProperty("customData")
    private CustomData customData;

}
