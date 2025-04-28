package com.example.demo.model.refdata;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "charginglimitsourceenumtype")
@Data
@NoArgsConstructor
public class Charginglimitsourceenumtype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", columnDefinition = "TEXT")
    private String Value;

    @Column(name = "description", columnDefinition = "TEXT")
    private String Description;

}
