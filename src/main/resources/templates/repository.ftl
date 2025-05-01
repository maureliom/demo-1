<#-- repository.ftl -->
package ${packageName};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ocpp.schema.jpa.${packageName?substring(packageName?last_index_of(".") + 1)}.${className};

@Repository
public interface ${repositoryName} extends JpaRepository<${className}, Long> {

}
