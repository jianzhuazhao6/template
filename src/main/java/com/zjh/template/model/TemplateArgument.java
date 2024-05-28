package com.zjh.template.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TemplateArgument {
    String groupId;
    String artifactId;
    String basePath;
    String modelName;
    Map<String, Object> dataMap;
    Map<String, String> packageTemplateMap;
}
