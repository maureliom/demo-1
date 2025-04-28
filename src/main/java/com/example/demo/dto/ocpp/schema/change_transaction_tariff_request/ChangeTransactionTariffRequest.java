package com.example.demo.dto.ocpp.schema.change_transaction_tariff_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class ChangeTransactionTariffRequest {


    @JsonProperty("tariff")
    private Tariff tariff;


    @Size(max = 36)
    /** Transaction id for new tariff. */
    @JsonProperty("transactionId")
    private String transactionId;


    @JsonProperty("customData")
    private CustomData customData;

}
