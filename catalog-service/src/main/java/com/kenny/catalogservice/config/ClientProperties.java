package com.kenny.catalogservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "catalog-service-ms")//Note Add @ConfigurationPropertiesScan to CatalogServiceApplication
@Data
public class ClientProperties {

    private String bookSize;
}
