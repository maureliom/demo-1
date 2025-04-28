package com.example.demo.dto.ocpp.schema.notify_web_payment_started_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class NotifyWebPaymentStartedRequest {


    @Min(0)
    /** EVSE id for which transaction is requested. */
    @JsonProperty("evseId")
    private Integer evseId;

    @Min(0.0)

    /** Timeout value in seconds after which no result of web payment process (e.g. QR code scanning) is to be expected anymore. */
    @JsonProperty("timeout")
    private Integer timeout;


    @JsonProperty("customData")
    private CustomData customData;

}
