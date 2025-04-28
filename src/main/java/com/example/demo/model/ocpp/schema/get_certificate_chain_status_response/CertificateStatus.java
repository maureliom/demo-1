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
public class CertificateStatus {


    @Column(name = "certificate_hash_data")
    private CertificateHashData certificateHashData;


    @Column(name = "source")
    private CertificateStatusSourceEnum source;


    @Column(name = "status")
    private CertificateStatusEnum status;


    @Column(name = "next_update")
    private String nextUpdate;


    @Column(name = "custom_data")
    private CustomData customData;

}
