package com.example.demo.model.ocpp.schema.cleared_charging_limit_request;

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
@Table(name = "cleared_charging_limit_request")
public class ClearedChargingLimitRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 20)
    /** Source of the charging limit. Allowed values defined in Appendix as ChargingLimitSourceEnumStringType. */
    @Column(name = "charging_limit_source")
    private String chargingLimitSource;


    @Min(0)
    /** EVSE Identifier. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
