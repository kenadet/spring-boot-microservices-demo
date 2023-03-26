package com.kenny.orderservice.config;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@Data
@ConfigurationProperties(prefix = "order-service-ms") //Note Add @ConfigurationPropertiesScan to OrderServiceApplication
public class ClientProperties {
    @NotNull
    URI catalogServiceUri;
}
