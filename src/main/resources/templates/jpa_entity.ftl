<#-- jpa_entity.ftl -->
package ${packageName};

<#if usesList>
import java.util.List;
import jakarta.persistence.ElementCollection;
</#if>

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

<#if description??>
/**
 * ${description?replace("\n", " ")?replace("\r", "")}
 */
</#if>
@Entity
@Table(name = "${tableName}")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class ${className} {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

<#list fields as field>

    ${field.jpaAnnotation}
    private ${field.type} ${field.name};
</#list>

}
