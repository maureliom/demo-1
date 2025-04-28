package com.example.demo.model.ocpp.schema.set_display_message_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.demo.model.ocpp.schema.enums.*;

@Data
@NoArgsConstructor
public class MessageInfo {


    @Column(name = "display")
    private Component display;


    @Min(0)
    /** Unique id within an exchange context. It is defined within the OCPP context as a positive Integer value (greater or equal to zero). */
    @Column(name = "id")
    private Integer id;

    @Min(0.0)

    @Column(name = "priority")
    private MessagePriorityEnum priority;


    @Column(name = "state")
    private MessageStateEnum state;


    /** From what date-time should this message be shown. If omitted: directly. */
    @Column(name = "start_date_time")
    private String startDateTime;


    /** Until what date-time should this message be shown, after this date/time this message SHALL be removed. */
    @Column(name = "end_date_time")
    private String endDateTime;


    @Size(max = 36)
    /** During which transaction shall this message be shown. Message SHALL be removed by the Charging Station after transaction has ended. */
    @Column(name = "transaction_id")
    private String transactionId;


    @Column(name = "message")
    private MessageContent message;


    @ElementCollection
    @Size(min = 1)
    @Size(max = 4)
    @Column(name = "message_extra")
    private List<MessageContent> messageExtra;

    @ElementCollection
    private List<MessageContent> messageExtra = new ArrayList<>();


    @Column(name = "custom_data")
    private CustomData customData;

}
