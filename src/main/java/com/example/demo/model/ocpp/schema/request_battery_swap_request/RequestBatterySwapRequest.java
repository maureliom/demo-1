package com.example.demo.model.ocpp.schema.request_battery_swap_request;

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
@Table(name = "request_battery_swap_request")
public class RequestBatterySwapRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "id_token")
    private IdToken idToken;


    /** Request id to match with BatterySwapRequest. */
    @Column(name = "request_id")
    private Integer requestId;


    @Column(name = "custom_data")
    private CustomData customData;

}
