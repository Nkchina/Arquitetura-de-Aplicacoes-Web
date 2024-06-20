package com.example.AV2.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @PostMapping("/orders")
    public String createOrder() {
        return "Order created!";
    }

    @PutMapping("/orders/{id}")
    public String updateOrder(@PathVariable Long id) {
        return "Order updated!";
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return "Order deleted!";
    }
}
