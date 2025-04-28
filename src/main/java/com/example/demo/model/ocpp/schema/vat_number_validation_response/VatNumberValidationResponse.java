package com.example.demo.model.ocpp.schema.vat_number_validation_response;

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
@Table(name = "vat_number_validation_response")
public class VatNumberValidationResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "company")
    private Address company;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @Size(max = 20)
    /** VAT number that was requested. */
    @Column(name = "vat_number")
    private String vatNumber;


    @Min(0)
    /** EVSE id for which check was requested. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "status")
    private GenericStatusEnum status;


    @Column(name = "custom_data")
    private CustomData customData;

}
