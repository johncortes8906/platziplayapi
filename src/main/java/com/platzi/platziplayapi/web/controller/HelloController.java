package com.platzi.platziplayapi.web.controller;

import com.platzi.platziplayapi.domain.services.PlatziPlayAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private PlatziPlayAiService aiService;
    private final String platform;

    public HelloController(PlatziPlayAiService aiService,
                           @Value("${spring.application.name}") String platform
    ) {
        this.aiService = aiService;
        this.platform = platform;
    }

    @GetMapping("/hello")
    public String hello() {

        return this.aiService.generateGretting(platform);
    }

}
