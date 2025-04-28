package com.example.demo.model.ocpp.schema.set_network_profile_request;

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
@Table(name = "set_network_profile_request")
public class SetNetworkProfileRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** Slot in which the configuration should be stored. */
    @Column(name = "configuration_slot")
    private Integer configurationSlot;


    @Column(name = "connection_data")
    private NetworkConnectionProfile connectionData;


    @Column(name = "custom_data")
    private CustomData customData;

}
