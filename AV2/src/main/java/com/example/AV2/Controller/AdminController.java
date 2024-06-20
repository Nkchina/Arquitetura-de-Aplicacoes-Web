package com.example.AV2.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/users")
    public String createUser() {
        return "User created!";
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable Long id) {
        return "User updated!";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        return "User deleted!";
    }
}
