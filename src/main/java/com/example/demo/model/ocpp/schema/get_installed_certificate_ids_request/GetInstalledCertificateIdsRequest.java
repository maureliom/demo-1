package com.example.demo.model.ocpp.schema.get_installed_certificate_ids_request;

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
@Table(name = "get_installed_certificate_ids_request")
public class GetInstalledCertificateIdsRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    /** Indicates the type of certificates requested. When omitted, all certificate types are requested. */
    @Column(name = "certificate_type")
    private List<GetCertificateIdUseEnum> certificateType;

    @ElementCollection
    private List<GetCertificateIdUseEnum> certificateType = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
