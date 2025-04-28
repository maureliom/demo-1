package com.example.demo.model.ocpp.schema.vat_number_validation_request;

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
@Table(name = "vat_number_validation_request")
public class VatNumberValidationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 20)
    /** VAT number to check. */
    @Column(name = "vat_number")
    private String vatNumber;


    @Min(0)
    /** EVSE id for which check is done */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
