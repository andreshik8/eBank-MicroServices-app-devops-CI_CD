package com.dev.customerservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.params")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class GlobalConfig {
    private int g1;
    private int g2;
}
