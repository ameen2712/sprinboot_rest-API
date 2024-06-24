package com.example.springboot_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldController {
    // http::localhost:8080/helloworld
    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello - world..!";
    }
}
