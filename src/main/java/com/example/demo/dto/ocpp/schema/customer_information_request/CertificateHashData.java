package com.example.demo.dto.ocpp.schema.customer_information_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CertificateHashData {


    @JsonProperty("hashAlgorithm")
    private HashAlgorithmEnum hashAlgorithm;


    @Size(max = 128)
    /** The hash of the issuer’s distinguished name (DN), that must be calculated over the DER encoding of the issuer’s name field in the certificate being checked. */
    @JsonProperty("issuerNameHash")
    private String issuerNameHash;


    @Size(max = 128)
    /** The hash of the DER encoded public key: the value (excluding tag and length) of the subject public key field in the issuer’s certificate. */
    @JsonProperty("issuerKeyHash")
    private String issuerKeyHash;


    @Size(max = 40)
    /** The string representation of the hexadecimal value of the serial number without the prefix \"0x\" and without leading zeroes. */
    @JsonProperty("serialNumber")
    private String serialNumber;


    @JsonProperty("customData")
    private CustomData customData;

}
