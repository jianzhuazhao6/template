package ${packageName}.repository;

import ${packageName}.model.${modelName}Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ${modelName}Repository extends JpaRepository<${modelName}Model, String> {

}