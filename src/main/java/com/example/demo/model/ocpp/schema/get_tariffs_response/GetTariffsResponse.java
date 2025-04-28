package com.example.demo.model.ocpp.schema.get_tariffs_response;

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
@Table(name = "get_tariffs_response")
public class GetTariffsResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "status")
    private TariffGetStatusEnum status;


    @Column(name = "status_info")
    private StatusInfo statusInfo;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "tariff_assignments")
    private List<TariffAssignment> tariffAssignments;

    @ElementCollection
    private List<TariffAssignment> tariffAssignments = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
