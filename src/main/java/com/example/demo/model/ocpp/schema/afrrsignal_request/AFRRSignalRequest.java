package com.example.demo.model.ocpp.schema.afrrsignal_request;

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
@Table(name = "afrrsignal_request")
public class AFRRSignalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** Time when signal becomes active. */
    @Column(name = "timestamp")
    private String timestamp;


    /** Value of signal in _v2xSignalWattCurve_. */
    @Column(name = "signal")
    private Integer signal;


    @Column(name = "custom_data")
    private CustomData customData;

}
