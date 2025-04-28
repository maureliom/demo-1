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
public class CertificateHashDataChain {


    @Column(name = "certificate_hash_data")
    private CertificateHashData certificateHashData;


    @Column(name = "certificate_type")
    private GetCertificateIdUseEnum certificateType;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @Column(name = "child_certificate_hash_data")
    private List<CertificateHashData> childCertificateHashData;

    @ElementCollection
    private List<CertificateHashData> childCertificateHashData = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
