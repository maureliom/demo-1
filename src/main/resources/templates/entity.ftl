package ${packageName};

import javax.persistence.*;
<#list imports as imp>
import ${imp};
</#list>

@Entity
public class ${className} {

<#list fields as field>
    @JsonProperty("${field.originalName}")
    <#if field.validation??>${field.validation}</#if>
    <#if field.jpaAnnotation??>${field.jpaAnnotation}</#if>
    private ${field.type} ${field.name};
</#list>

}
