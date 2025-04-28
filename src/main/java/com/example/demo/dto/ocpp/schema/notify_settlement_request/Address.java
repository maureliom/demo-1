package com.example.demo.dto.ocpp.schema.notify_settlement_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class Address {


    @Size(max = 50)
    /** Name of person/company */
    @JsonProperty("name")
    private String name;


    @Size(max = 100)
    /** Address line 1 */
    @JsonProperty("address1")
    private String address1;


    @Size(max = 100)
    /** Address line 2 */
    @JsonProperty("address2")
    private String address2;


    @Size(max = 100)
    /** City */
    @JsonProperty("city")
    private String city;


    @Size(max = 20)
    /** Postal code */
    @JsonProperty("postalCode")
    private String postalCode;


    @Size(max = 50)
    /** Country name */
    @JsonProperty("country")
    private String country;


    @JsonProperty("customData")
    private CustomData customData;

}
