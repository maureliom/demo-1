package com.example.demo.dto.ocpp.schema.notify_customer_information_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyCustomerInformationResponse {


    @JsonProperty("customData")
    private CustomData customData;

}
