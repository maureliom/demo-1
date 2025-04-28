package com.example.demo.model.ocpp.schema.pull_dynamic_schedule_update_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class StatusInfo {


    @Size(max = 20)
    /** A predefined code for the reason why the status is returned in this response. The string is case-insensitive. */
    @Column(name = "reason_code")
    private String reasonCode;


    @Size(max = 1024)
    /** Additional text to provide detailed information. */
    @Column(name = "additional_info")
    private String additionalInfo;


    @Column(name = "custom_data")
    private CustomData customData;

}
