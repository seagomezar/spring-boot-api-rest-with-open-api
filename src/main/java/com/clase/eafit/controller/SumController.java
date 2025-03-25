package com.clase.eafit.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
    @Tag(name = "Sum Controller", description = "Controller for adding two numbers")
public class SumController {

    @Operation(operationId = "addTwoNumbers", summary = "Add two numbers", description = "Returns the sum of two numbers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"sum\": 3}", description = "The sum of the two numbers"))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(mediaType = "text/plain", schema = @Schema(example = "Both num1 and num2 must be provided", description = "Error message")))
    })
    @PostMapping("/sum")
    public Map<String, Integer> sum(@Parameter(description = "Request body containing two numbers", schema = @Schema(example = "{\"num1\": 1, \"num2\": 2}")) @RequestBody Map<String, Integer> body) {
        Integer num1 = body.get("num1");
        Integer num2 = body.get("num2");
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Both num1 and num2 must be provided");
        }
        Integer sum = num1 + num2;
        return Map.of("sum", sum);
    }
}
