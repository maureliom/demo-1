package com.example.demo.model.ocpp.schema.reserve_now_request;

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
@Table(name = "reserve_now_request")
public class ReserveNowRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Min(0)
    /** Id of reservation. */
    @Column(name = "id")
    private Integer id;

    @Min(0.0)

    /** Date and time at which the reservation expires. */
    @Column(name = "expiry_date_time")
    private String expiryDateTime;


    @Size(max = 20)
    /** This field specifies the connector type. Values defined in Appendix as ConnectorEnumStringType. */
    @Column(name = "connector_type")
    private String connectorType;


    @Column(name = "id_token")
    private IdToken idToken;


    @Min(0)
    /** This contains ID of the evse to be reserved. */
    @Column(name = "evse_id")
    private Integer evseId;

    @Min(0.0)

    @Column(name = "group_id_token")
    private IdToken groupIdToken;


    @Column(name = "custom_data")
    private CustomData customData;

}
