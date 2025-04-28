package com.example.demo.dto.ocpp.schema.notify_report_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class VariableCharacteristics {


    @Size(max = 16)
    /** Unit of the variable. When the transmitted value has a unit, this field SHALL be included. */
    @JsonProperty("unit")
    private String unit;


    @JsonProperty("dataType")
    private DataEnum dataType;


    /** Minimum possible value of this variable. */
    @JsonProperty("minLimit")
    private Double minLimit;


    /** Maximum possible value of this variable. When the datatype of this Variable is String, OptionList, SequenceList or MemberList, this field defines the maximum length of the (CSV) string. */
    @JsonProperty("maxLimit")
    private Double maxLimit;


    @Min(1)
    /** *(2.1)* Maximum number of elements from _valuesList_ that are supported as _attributeValue_. */
    @JsonProperty("maxElements")
    private Integer maxElements;

    @Min(1.0)

    @Size(max = 1000)
    /** Mandatory when _dataType_ = OptionList, MemberList or SequenceList. In that case _valuesList_ specifies the allowed values for the type. The length of this field can be limited by DeviceDataCtrlr.ConfigurationValueSize. * OptionList: The (Actual) Variable value must be a single value from the reported (CSV) enumeration list. * MemberList: The (Actual) Variable value may be an (unordered) (sub-)set of the reported (CSV) valid values list. * SequenceList: The (Actual) Variable value may be an ordered (priority, etc) (sub-)set of the reported (CSV) valid values. This is a comma separated list. The Configuration Variable &lt;&lt;configkey-configuration-value-size,ConfigurationValueSize&gt;&gt; can be used to limit SetVariableData.attributeValue and VariableCharacteristics.valuesList. The max size of these values will always remain equal. */
    @JsonProperty("valuesList")
    private String valuesList;


    /** Flag indicating if this variable supports monitoring. */
    @JsonProperty("supportsMonitoring")
    private Boolean supportsMonitoring;


    @JsonProperty("customData")
    private CustomData customData;

}
