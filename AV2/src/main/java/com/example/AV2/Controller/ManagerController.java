package com.example.AV2.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @PostMapping("/products")
    public String createProduct() {
        return "Product created!";
    }

    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id) {
        return "Product updated!";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return "Product deleted!";
    }
}
