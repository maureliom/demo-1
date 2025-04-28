package com.example.demo.model.ocpp.schema.get_tariffs_request;

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
@Table(name = "get_tariffs_request")
public class GetTariffsRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** EVSE id to get tariff from. When _evseId_ = 0, this gets tariffs from all EVSEs. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
