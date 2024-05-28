package com.zjh.template.web.controller;

import com.zjh.template.model.TemplateArgument;
import com.zjh.template.util.TemplateUtil;
import com.zjh.template.web.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
public class CodeController {

    @Autowired
    private TemplateUtil templateUtil;

    @PostMapping("/generate")
    public ResponseEntity<MessageVo> generateCode(@RequestBody TemplateArgument templateArgument) throws Exception {
        templateUtil.generateFiles(templateArgument);
        return ResponseEntity.ok(MessageVo.builder()
                .message("success")
                .build());
    }
}
