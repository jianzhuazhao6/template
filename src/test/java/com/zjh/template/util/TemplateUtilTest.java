package com.zjh.template.util;

import com.zjh.template.model.TemplateArgument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest
class TemplateUtilTest {

    @Autowired
    private TemplateUtil templateUtil;

    @Test
    void createJavaFile() throws Exception {
        templateUtil.generateFile(getTemplateArgument());
    }

    private TemplateArgument getTemplateArgument() {

        Map<String, Object> map = new HashMap<>();
        map.put("packageName", "com.zhaomsdemo.research.datahub");
        map.put("modelName","User");
        return TemplateArgument.builder()
                .artifactId("datahub")
                .groupId("com.zhaomsdemo.research")
                .basePath("/home/zhaojh/files")
                .modelName("User")
                .dataMap(map)
                .packageTemplateMap(Map.of(
                        "repository", "repository"
                        ,"model","model"
                        ,"service","service"
                        ,"controller","controller"
                ))
                .build();
    }
}