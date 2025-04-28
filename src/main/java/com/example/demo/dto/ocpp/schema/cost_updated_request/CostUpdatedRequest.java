package com.example.demo.dto.ocpp.schema.cost_updated_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CostUpdatedRequest {


    /** Current total cost, based on the information known by the CSMS, of the transaction including taxes. In the currency configured with the configuration Variable: [&lt;&lt;configkey-currency, Currency&gt;&gt;] */
    @JsonProperty("totalCost")
    private Double totalCost;


    @Size(max = 36)
    /** Transaction Id of the transaction the current cost are asked for. */
    @JsonProperty("transactionId")
    private String transactionId;


    @JsonProperty("customData")
    private CustomData customData;

}
