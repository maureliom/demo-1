package com.example.demo.model.ocpp.schema.get_installed_certificate_ids_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CertificateHashData {


    @Column(name = "hash_algorithm")
    private HashAlgorithmEnum hashAlgorithm;


    @Size(max = 128)
    /** The hash of the issuer’s distinguished name (DN), that must be calculated over the DER encoding of the issuer’s name field in the certificate being checked. */
    @Column(name = "issuer_name_hash")
    private String issuerNameHash;


    @Size(max = 128)
    /** The hash of the DER encoded public key: the value (excluding tag and length) of the subject public key field in the issuer’s certificate. */
    @Column(name = "issuer_key_hash")
    private String issuerKeyHash;


    @Size(max = 40)
    /** The string representation of the hexadecimal value of the serial number without the prefix \"0x\" and without leading zeroes. */
    @Column(name = "serial_number")
    private String serialNumber;


    @Column(name = "custom_data")
    private CustomData customData;

}
