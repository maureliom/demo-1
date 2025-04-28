package com.example.demo.dto.ocpp.schema.boot_notification_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Modem {


    @Size(max = 20)
    /** This contains the ICCID of the modem’s SIM card. */
    @JsonProperty("iccid")
    private String iccid;


    @Size(max = 20)
    /** This contains the IMSI of the modem’s SIM card. */
    @JsonProperty("imsi")
    private String imsi;


    @JsonProperty("customData")
    private CustomData customData;

}
