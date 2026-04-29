package com.platzi.platziplayapi;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {
    
    @UserMessage("Create a friendly greeting to welcome user to Platzi Play platform where the user" +
            " can watch multiple movies and documentaries. Use no more than 90 characters and apply the Platzi style." +
            "Use only English in your output.")
    String generateGretting();
}
