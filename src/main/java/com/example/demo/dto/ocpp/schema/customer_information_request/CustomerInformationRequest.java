package com.example.demo.dto.ocpp.schema.customer_information_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CustomerInformationRequest {


    @JsonProperty("customerCertificate")
    private CertificateHashData customerCertificate;


    @JsonProperty("idToken")
    private IdToken idToken;


    @Min(0)
    /** The Id of the request. */
    @JsonProperty("requestId")
    private Integer requestId;

    @Min(0.0)

    /** Flag indicating whether the Charging Station should return NotifyCustomerInformationRequest messages containing information about the customer referred to. */
    @JsonProperty("report")
    private Boolean report;


    /** Flag indicating whether the Charging Station should clear all information about the customer referred to. */
    @JsonProperty("clear")
    private Boolean clear;


    @Size(max = 64)
    /** A (e.g. vendor specific) identifier of the customer this request refers to. This field contains a custom identifier other than IdToken and Certificate. One of the possible identifiers (customerIdentifier, customerIdToken or customerCertificate) should be in the request message. */
    @JsonProperty("customerIdentifier")
    private String customerIdentifier;


    @JsonProperty("customData")
    private CustomData customData;

}
