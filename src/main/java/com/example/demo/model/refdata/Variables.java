package com.example.demo.model.refdata;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "variables")
@Data
@NoArgsConstructor
public class Variables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name ", columnDefinition = "TEXT")
    private String Name;

    @Column(name = " data_type ", columnDefinition = "TEXT")
    private String Datatype;

    @Column(name = " unit ", columnDefinition = "TEXT")
    private String Unit;

    @Column(name = " description", columnDefinition = "TEXT")
    private String Description;

}
