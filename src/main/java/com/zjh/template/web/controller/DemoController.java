package com.zjh.template.web.controller;

import com.zjh.template.web.vo.MessageVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "DemoController")
public class DemoController {

    @GetMapping("/success")
    @Operation(summary = "a demo controller to show success message")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ResponseEntity.class), mediaType = "application/json")
            })
    })
    public ResponseEntity<MessageVo> showSuccessMessage(@RequestParam String message) {
        return ResponseEntity.ok(MessageVo.builder()
                .message(message)
                .build());
    }
}
