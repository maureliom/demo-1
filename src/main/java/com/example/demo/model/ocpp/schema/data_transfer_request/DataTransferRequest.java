package com.example.demo.model.ocpp.schema.data_transfer_request;

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
@Table(name = "data_transfer_request")
public class DataTransferRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemaId;


    @Size(max = 50)
    /** May be used to indicate a specific message or implementation. */
    @Column(name = "message_id")
    private String messageId;


    /** Data without specified length or format. This needs to be decided by both parties (Open to implementation). */
    @Column(name = "data")
    private String data;


    @Size(max = 255)
    /** This identifies the Vendor specific implementation */
    @Column(name = "vendor_id")
    private String vendorId;


    @Column(name = "custom_data")
    private CustomData customData;

}
