package com.example.demo.model.ocpp.schema.reset_request;

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
@Table(name = "reset_request")
public class ResetRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "type")
    private ResetEnum type;


    @Min(0)
    /** This contains the ID of a specific EVSE that needs to be reset, instead of the entire Charging Station. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
