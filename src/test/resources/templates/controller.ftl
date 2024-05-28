package ${packageName}.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ${packageName}.model.${modelName}Model;
import ${packageName}.service.${modelName}Service;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ${modelName}Controller {

    final ${modelName}Service ${modelName?uncap_first}Service;

    @GetMapping("/${modelName?uncap_first}s?pageSize={pageSize}&pageNum={pageNum}")
    public ResponseEntity<List<${modelName}>> getAll${modelName}s(@PathVariable int pageNum,@PathVariable int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        List<${modelName}> ${modelName?uncap_first}s = ${modelName?uncap_first}Service.findAll(pageRequest);
        return ResponseEntity.ok(${modelName?uncap_first}s);
    }

    @GetMapping("/${modelName?uncap_first}/{id}")
    public ResponseEntity<${modelName}> findById(@PathVariable String id) {
        ${modelName} ${modelName?uncap_first} = ${modelName?uncap_first}Service.findById(id);
        return ResponseEntity.ok(${modelName?uncap_first});
    }

    @PostMapping("/${modelName?uncap_first}")
    public ResponseEntity<${modelName}> create${modelName}(@RequestBody ${modelName} ${modelName?uncap_first}) {
        ${modelName} new${modelName} =  ${modelName?uncap_first}Service.create${modelName}(${modelName?uncap_first});
        return ResponseEntity.ok(new${modelName});
    }

    @PutMapping("/{id}")
    public ResponseEntity<${modelName}> update${modelName}(@PathVariable String id, @RequestBody ${modelName} ${modelName?uncap_first}) {
        ${modelName} existing${modelName} = ${modelName?uncap_first}Service.findById(id);
        if (existing${modelName} == null) {
            return ResponseEntity.notFound().build();
        }
        existing${modelName} = ${modelName?uncap_first}Service.update${modelName}(${modelName?uncap_first});
        return ResponseEntity.ok(existing${modelName});
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete${modelName}(@PathVariable String id) {
        ${modelName} existing${modelName} = ${modelName?uncap_first}Service.findById(id);
        if (existing${modelName} == null) {
            return ResponseEntity.notFound().build();
        }
        ${modelName?uncap_first}Service.delete${modelName}(id);
        return ResponseEntity.ok().build();
    }
}