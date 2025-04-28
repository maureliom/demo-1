package com.example.demo.model.ocpp.schema.boot_notification_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Modem {


    @Size(max = 20)
    /** This contains the ICCID of the modem’s SIM card. */
    @Column(name = "iccid")
    private String iccid;


    @Size(max = 20)
    /** This contains the IMSI of the modem’s SIM card. */
    @Column(name = "imsi")
    private String imsi;


    @Column(name = "custom_data")
    private CustomData customData;

}
