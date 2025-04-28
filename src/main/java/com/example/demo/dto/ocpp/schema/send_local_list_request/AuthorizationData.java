package com.example.demo.dto.ocpp.schema.send_local_list_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class AuthorizationData {


    @JsonProperty("idToken")
    private IdToken idToken;


    @JsonProperty("idTokenInfo")
    private IdTokenInfo idTokenInfo;


    @JsonProperty("customData")
    private CustomData customData;

}
