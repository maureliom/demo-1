<#-- enum.ftl -->
package ${packageName};
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape.*;
import com.fasterxml.jackson.annotation.JsonProperty;
<#if description??>
/**
 * ${description?replace("\n", " ")?replace("\r", "")}
 */
</#if>
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum ${enumName} {

<#list constants as const>
    @JsonProperty("${const.originalValue()}")
    ${const.name()}("${const.originalValue()}")<#if const_has_next>,</#if>
</#list>;

    private final String value;

    ${enumName}(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
