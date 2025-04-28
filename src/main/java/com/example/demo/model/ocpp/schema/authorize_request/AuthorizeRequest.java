package com.example.demo.model.ocpp.schema.authorize_request;

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
@Table(name = "authorize_request")
public class AuthorizeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "id_token")
    private IdToken idToken;


    @Size(max = 10000)
    /** *(2.1)* The X.509 certificate chain presented by EV and encoded in PEM format. Order of certificates in chain is from leaf up to (but excluding) root certificate. + Only needed in case of central contract validation when Charging Station cannot validate the contract certificate. */
    @Column(name = "certificate")
    private String certificate;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @Column(name = "iso15118certificate_hash_data")
    private List<OCSPRequestData> iso15118CertificateHashData;

    @ElementCollection
    private List<OCSPRequestData> iso15118CertificateHashData = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
