package com.example.demo.model.ocpp.schema.customer_information_request;

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
@Table(name = "customer_information_request")
public class CustomerInformationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "customer_certificate")
    private CertificateHashData customerCertificate;


    @Column(name = "id_token")
    private IdToken idToken;


    @Min(0)
    /** The Id of the request. */
    @Column(name = "request_id")
    private Integer requestId;

    @Min(0.0)

    /** Flag indicating whether the Charging Station should return NotifyCustomerInformationRequest messages containing information about the customer referred to. */
    @Column(name = "report")
    private Boolean report;


    /** Flag indicating whether the Charging Station should clear all information about the customer referred to. */
    @Column(name = "clear")
    private Boolean clear;


    @Size(max = 64)
    /** A (e.g. vendor specific) identifier of the customer this request refers to. This field contains a custom identifier other than IdToken and Certificate. One of the possible identifiers (customerIdentifier, customerIdToken or customerCertificate) should be in the request message. */
    @Column(name = "customer_identifier")
    private String customerIdentifier;


    @Column(name = "custom_data")
    private CustomData customData;

}
