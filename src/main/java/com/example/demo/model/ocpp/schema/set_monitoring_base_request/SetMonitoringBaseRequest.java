package com.example.demo.model.ocpp.schema.set_monitoring_base_request;

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
@Table(name = "set_monitoring_base_request")
public class SetMonitoringBaseRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Column(name = "monitoring_base")
    private MonitoringBaseEnum monitoringBase;


    @Column(name = "custom_data")
    private CustomData customData;

}
