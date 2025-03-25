package com.clase.eafit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Product Controller", description = "Controller for managing products")
public class ProductController {

    @Schema(name = "Product", description = "Product information")
    private static class Product {
        @Schema(description = "Product ID", example = "1")
        private Long id;
        @Schema(description = "Product name", example = "Laptop")
        private String name;
        @Schema(description = "Product price", example = "1200.00")
        private Double price;

        public Product(Long id, String name, Double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Double getPrice() {
            return price;
        }
    }

    @Operation(summary = "Get all products", description = "Returns a list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Product.class))))
    })
    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Laptop", 1200.00));
        products.add(new Product(2L, "Keyboard", 75.00));
        products.add(new Product(3L, "Mouse", 25.00));
        return products;
    }
}
