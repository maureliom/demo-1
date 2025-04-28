package com.example.demo.model.ocpp.schema.vat_number_validation_response;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Address {


    @Size(max = 50)
    /** Name of person/company */
    @Column(name = "name")
    private String name;


    @Size(max = 100)
    /** Address line 1 */
    @Column(name = "address1")
    private String address1;


    @Size(max = 100)
    /** Address line 2 */
    @Column(name = "address2")
    private String address2;


    @Size(max = 100)
    /** City */
    @Column(name = "city")
    private String city;


    @Size(max = 20)
    /** Postal code */
    @Column(name = "postal_code")
    private String postalCode;


    @Size(max = 50)
    /** Country name */
    @Column(name = "country")
    private String country;


    @Column(name = "custom_data")
    private CustomData customData;

}
