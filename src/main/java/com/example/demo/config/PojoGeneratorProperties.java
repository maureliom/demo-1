package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "pojo.generator")
public class PojoGeneratorProperties {
    private boolean treatWarningsAsErrors;
    private boolean generateValidationAnnotations;
    private boolean dryRunMode;
    private String schemaDirectory;
}
