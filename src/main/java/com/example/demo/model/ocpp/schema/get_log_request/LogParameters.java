package com.example.demo.model.ocpp.schema.get_log_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class LogParameters {


    @Size(max = 2000)
    /** The URL of the location at the remote system where the log should be stored. */
    @Column(name = "remote_location")
    private String remoteLocation;


    /** This contains the date and time of the oldest logging information to include in the diagnostics. */
    @Column(name = "oldest_timestamp")
    private String oldestTimestamp;


    /** This contains the date and time of the latest logging information to include in the diagnostics. */
    @Column(name = "latest_timestamp")
    private String latestTimestamp;


    @Column(name = "custom_data")
    private CustomData customData;

}
