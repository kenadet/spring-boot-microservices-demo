package com.kenny.catalogservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "book")
@Data
public class CustomProperties {

    private String size;
}
