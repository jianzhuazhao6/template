package com.zjh.template.util;

import com.zjh.template.model.TemplateArgument;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TemplateUtil {

    private final static String PATH_SEPARATOR = File.separator;

    Configuration configuration;

    @PostConstruct
    public void init() throws IOException {
        String templates = this.getClass().getClassLoader().getResource("templates").getPath();
        FileTemplateLoader fileTemplateLoader = new FileTemplateLoader(new File(templates));
        configuration.setTemplateLoader(fileTemplateLoader);
        configuration.setDefaultEncoding("UTF-8");
    }

    public void generateFiles(TemplateArgument templateArgument) throws Exception {
        String artifactPath = templateArgument.getArtifactId();
        String basePath = templateArgument.getBasePath();
        String groupPath = String.join(PATH_SEPARATOR, templateArgument.getGroupId().split("\\."));
        String modelName = templateArgument.getModelName();

        templateArgument.getPackageTemplateMap().entrySet().stream().forEach(entry -> {
            String key = entry.getKey();
            String value = entry.getValue();
            String directory = String.join(PATH_SEPARATOR, basePath, groupPath, artifactPath, key);
            try {
                Files.createDirectories(Paths.get(directory));
                Template template = configuration.getTemplate(value + ".ftl");
                String fileName = directory + PATH_SEPARATOR + capitalize(modelName) + capitalize(key) + ".java";
                template.process(templateArgument.getDataMap(), new PrintWriter(fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (TemplateException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
