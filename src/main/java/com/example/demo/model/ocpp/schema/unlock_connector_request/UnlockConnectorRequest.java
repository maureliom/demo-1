package com.example.demo.model.ocpp.schema.unlock_connector_request;

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
@Table(name = "unlock_connector_request")
public class UnlockConnectorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** This contains the identifier of the EVSE for which a connector needs to be unlocked. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Min(0)
    /** This contains the identifier of the connector that needs to be unlocked. */
    @Column(name = "connector_id")
    private Integer connectorId;

    @Min(0.0)

    @Column(name = "custom_data")
    private CustomData customData;

}
