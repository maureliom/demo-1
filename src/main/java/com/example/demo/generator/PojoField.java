package com.example.demo.generator;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PojoField {
    private String originalName; // from schema
    private String name;         // lowerCamelCase
    private String type;         // Java type
    private String description;
    private boolean isRelation;
	private String relationType; // OneToOne, ManyToOne, etc.
	private boolean isEnum;
	private boolean isRequired;
	private String jpaAnnotation;
	private String validation;
    }
