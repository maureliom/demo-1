<#-- pojo.ftl -->
package ${packageName};

<#if usesList>
import java.util.List;
</#if>
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.*;

<#if description??>
/**
 * ${description?replace("\n", " ")?replace("\r", "")}
 */
</#if>
@Data
@JsonInclude(Include.NON_NULL)
public class ${className} {

<#list fields as field>
    <#if field.description??>
    /**
     * ${field.description?replace("\n", " ")?replace("\r", "")}
     */
    </#if>
    
    @JsonProperty("${field.originalName}")
    <#if field.validation?? && field.validation?trim?length gt 0>
    <#list field.validation?split("\\n") as ann>
    ${ann}
    </#list>
    </#if>
    private ${field.type} ${field.name};
</#list>
}