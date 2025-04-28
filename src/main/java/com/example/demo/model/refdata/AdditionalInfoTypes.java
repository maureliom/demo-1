package com.example.demo.model.refdata;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "additional_info_types")
@Data
@NoArgsConstructor
public class AdditionalInfoTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "additional_info.type", columnDefinition = "TEXT")
    private String AdditionalinfoType;

    @Column(name = "description", columnDefinition = "TEXT")
    private String Description;

}
