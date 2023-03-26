package com.kenny.catalogservice.controller;

import com.kenny.catalogservice.config.ClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final ClientProperties customProperties;

    public HomeController(ClientProperties customProperties){
        this.customProperties = customProperties;
    }

    @GetMapping("/")
    public int get() {
        return Integer.parseInt(customProperties.getBookSize());
    }

}
