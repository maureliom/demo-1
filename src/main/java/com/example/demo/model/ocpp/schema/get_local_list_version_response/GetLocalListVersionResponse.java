package com.example.demo.model.ocpp.schema.get_local_list_version_response;

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
@Table(name = "get_local_list_version_response")
public class GetLocalListVersionResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    /** This contains the current version number of the local authorization list in the Charging Station. */
    @Column(name = "version_number")
    private Integer versionNumber;


    @Column(name = "custom_data")
    private CustomData customData;

}
