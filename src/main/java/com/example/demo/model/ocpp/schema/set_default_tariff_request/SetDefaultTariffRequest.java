package com.example.demo.model.ocpp.schema.set_default_tariff_request;

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
@Table(name = "set_default_tariff_request")
public class SetDefaultTariffRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** EVSE that tariff applies to. When _evseId_ = 0, then tarriff applies to all EVSEs. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "tariff")
    private Tariff tariff;


    @Column(name = "custom_data")
    private CustomData customData;

}
