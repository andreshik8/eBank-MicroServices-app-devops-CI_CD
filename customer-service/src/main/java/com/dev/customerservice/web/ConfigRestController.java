package com.dev.customerservice.web;

import com.dev.customerservice.config.GlobalConfig;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
@AllArgsConstructor
public class ConfigRestController {
    private GlobalConfig globalConfig;

    @GetMapping("getConfig")
    public Map<String, Integer> getConfiguration() {
        return Map.of("g1", globalConfig.getG1(),"g2", globalConfig.getG2());
    }
}
