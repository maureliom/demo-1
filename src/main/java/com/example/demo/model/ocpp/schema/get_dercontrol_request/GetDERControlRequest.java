package com.example.demo.model.ocpp.schema.get_dercontrol_request;

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
@Table(name = "get_dercontrol_request")
public class GetDERControlRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** RequestId to be used in ReportDERControlRequest. */
    @Column(name = "request_id")
    private Integer requestId;


    /** True: get a default DER control. False: get a scheduled control. */
    @Column(name = "is_default")
    private Boolean isDefault;


    @Column(name = "control_type")
    private DERControlEnum controlType;


    @Size(max = 36)
    /** Id of setting to get. When omitted all settings for _controlType_ are retrieved. */
    @Column(name = "control_id")
    private String controlId;


    @Column(name = "custom_data")
    private CustomData customData;

}
