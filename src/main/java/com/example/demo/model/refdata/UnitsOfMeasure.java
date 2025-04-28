package com.example.demo.model.refdata;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "units_of_measure")
@Data
@NoArgsConstructor
public class UnitsOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", columnDefinition = "TEXT")
    private String Value;

    @Column(name = "description", columnDefinition = "TEXT")
    private String Description;

}
