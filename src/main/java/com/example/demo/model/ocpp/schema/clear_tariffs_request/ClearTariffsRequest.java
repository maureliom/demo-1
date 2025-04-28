package com.example.demo.model.ocpp.schema.clear_tariffs_request;

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
@Table(name = "clear_tariffs_request")
public class ClearTariffsRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    /** List of tariff Ids to clear. When absent clears all tariffs at _evseId_. */
    @Column(name = "tariff_ids")
    private List<String> tariffIds;

    @ElementCollection
    private List<String> tariffIds = new ArrayList<>();


    @Min(0)
    /** When present only clear tariffs matching _tariffIds_ at EVSE _evseId_. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
