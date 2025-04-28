package com.example.demo.model.ocpp.schema.get_certificate_chain_status_response;

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
@Table(name = "get_certificate_chain_status_response")
public class GetCertificateChainStatusResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @Column(name = "certificate_status")
    private List<CertificateStatus> certificateStatus;

    @ElementCollection
    private List<CertificateStatus> certificateStatus = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
