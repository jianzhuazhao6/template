package ${packageName}.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "${modelName}Model")
public class ${modelName}Model {

    @Id
    String id;
}