package com.example.demo.model.ocpp.schema.set_variables_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class CustomData {


    @Size(max = 255)
    @Column(name = "vendor_id")
    private String vendorId;

}
