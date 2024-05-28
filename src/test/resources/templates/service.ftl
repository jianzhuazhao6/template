package ${packageName}.service;

import ${packageName}.model.${modelName}Model;
import ${packageName}.repository.${modelName}Repository;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ${modelName}Service {

    final ${modelName}Repository ${modelName?uncap_first}Repository;

    public List<${modelName}> findAll(Pageable pageable) {
        return ${modelName?uncap_first}Repository.findAll(pageable).getContent();
    }

    public Optional<${modelName}> findById(String id) {
        return ${modelName?uncap_first}Repository.findById(id);
    }

    public ${modelName} create${modelName}(${modelName} ${modelName?uncap_first}) {
        return ${modelName?uncap_first}Repository.save(${modelName?uncap_first});
    }

    public ${modelName} update${modelName}(String id, ${modelName} ${modelName?uncap_first}) {
        ${modelName} ${modelName?uncap_first} = ${modelName?uncap_first}Repository.findById(id).get();
        return ${modelName?uncap_first}Repository.save(${modelName?uncap_first});
    }

    public ${modelName} delete${modelName}(String id) {
        return ${modelName?uncap_first}Repository.deleteById(id);
    }
}