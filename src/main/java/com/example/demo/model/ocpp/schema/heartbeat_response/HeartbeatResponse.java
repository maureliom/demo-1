package com.example.demo.model.ocpp.schema.heartbeat_response;

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
@Table(name = "heartbeat_response")
public class HeartbeatResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** Contains the current time of the CSMS. */
    @Column(name = "current_time")
    private String currentTime;


    @Column(name = "custom_data")
    private CustomData customData;

}
