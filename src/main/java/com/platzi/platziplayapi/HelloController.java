package com.platzi.platziplayapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private PlatziPlayAiService aiService;

    public HelloController(PlatziPlayAiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/")
    public String hello() {

        return this.aiService.generateGretting();
    }

}
