package com.example.demo.model.ocpp.schema.send_local_list_request;

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
@Table(name = "send_local_list_request")
public class SendLocalListRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @ElementCollection
    @Size(min = 1)
    @Column(name = "local_authorization_list")
    private List<AuthorizationData> localAuthorizationList;

    @ElementCollection
    private List<AuthorizationData> localAuthorizationList = new ArrayList<>();


    /** In case of a full update this is the version number of the full list. In case of a differential update it is the version number of the list after the update has been applied. */
    @Column(name = "version_number")
    private Integer versionNumber;


    @Column(name = "update_type")
    private UpdateEnum updateType;


    @Column(name = "custom_data")
    private CustomData customData;

}
