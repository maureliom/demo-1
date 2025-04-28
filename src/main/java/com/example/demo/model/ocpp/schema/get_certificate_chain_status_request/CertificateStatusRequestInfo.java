package com.example.demo.model.ocpp.schema.get_certificate_chain_status_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CertificateStatusRequestInfo {


    @Column(name = "certificate_hash_data")
    private CertificateHashData certificateHashData;


    @Column(name = "source")
    private CertificateStatusSourceEnum source;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 5)
    /** URL(s) of _source_. */
    @Column(name = "urls")
    private List<String> urls;

    @ElementCollection
    private List<String> urls = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
