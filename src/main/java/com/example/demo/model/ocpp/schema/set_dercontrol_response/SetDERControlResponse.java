package com.example.demo.model.ocpp.schema.set_dercontrol_response;

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
@Table(name = "set_dercontrol_response")
public class SetDERControlResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private DERControlStatusEnum status;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 24)
    /** List of controlIds that are superseded as a result of setting this control. */
    @Column(name = "superseded_ids")
    private List<String> supersededIds;

    @ElementCollection
    private List<String> supersededIds = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
