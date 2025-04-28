package com.example.demo.model.ocpp.schema.get_monitoring_report_request;

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
@Table(name = "get_monitoring_report_request")
public class GetMonitoringReportRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "component_variable")
    private List<ComponentVariable> componentVariable;

    @ElementCollection
    private List<ComponentVariable> componentVariable = new ArrayList<>();


    /** The Id of the request. */
    @Column(name = "request_id")
    private Integer requestId;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 3)
    /** This field contains criteria for components for which a monitoring report is requested */
    @Column(name = "monitoring_criteria")
    private List<MonitoringCriterionEnum> monitoringCriteria;

    @ElementCollection
    private List<MonitoringCriterionEnum> monitoringCriteria = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
