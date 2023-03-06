package com.kenny.catalogservice.controller;

import com.kenny.catalogservice.config.CustomProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final CustomProperties customProperties;

    public HomeController(CustomProperties customProperties){
        this.customProperties = customProperties;
    }

    @GetMapping("/")
    public int get() {
        return Integer.parseInt(customProperties.getSize());
    }

}
