package com.example.demo.model.ocpp.schema.notify_web_payment_started_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "notify_web_payment_started_request")
public class NotifyWebPaymentStartedRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** EVSE id for which transaction is requested. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    /** Timeout value in seconds after which no result of web payment process (e.g. QR code scanning) is to be expected anymore. */
    @Column(name = "timeout")
    private Integer timeout;


    @Column(name = "custom_data")
    private CustomData customData;

}
