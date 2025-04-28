package com.example.demo.model.refdata;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dm_components_vars")
@Data
@NoArgsConstructor
public class DmComponentsVars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "specific component", columnDefinition = "TEXT")
    private String SpecificComponent;

    @Column(name = "variable", columnDefinition = "TEXT")
    private String Variable;

    @Column(name = "instance", columnDefinition = "TEXT")
    private String Instance;

    @Column(name = "required?", columnDefinition = "TEXT")
    private String Required;

    @Column(name = "data_type", columnDefinition = "TEXT")
    private String Datatype;

    @Column(name = "unit", columnDefinition = "TEXT")
    private String Unit;

    @Column(name = "description", columnDefinition = "TEXT")
    private String Description;

}
