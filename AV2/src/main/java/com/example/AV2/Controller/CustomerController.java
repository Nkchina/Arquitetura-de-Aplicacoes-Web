package com.example.AV2.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/products")
    public String viewProducts() {
        return "Product catalog!";
    }

    @GetMapping("/orders")
    public String viewOrders() {
        return "Order history!";
    }
}
