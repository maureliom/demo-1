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
@Entity
@Table(name = "get_installed_certificate_ids_response")
public class GetInstalledCertificateIdsResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private GetInstalledCertificateStatusEnum status;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "certificate_hash_data_chain")
    private List<CertificateHashDataChain> certificateHashDataChain;

    @ElementCollection
    private List<CertificateHashDataChain> certificateHashDataChain = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
