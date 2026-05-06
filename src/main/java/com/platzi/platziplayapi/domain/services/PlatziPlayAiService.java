package com.platzi.platziplayapi.domain.services;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {
    
    @UserMessage("Create a friendly greeting to welcome user to {{platform}} platform where the user" +
            " can watch multiple movies and documentaries. Use no more than 90 characters and apply the Platzi style." +
            "Use only English in your output.")
    String generateGretting(@V("platform") String platform);

    @SystemMessage("You're an expert of movie reviews that recommends movies according to the user's preferences. " +
            "You must list maximum 3 movies." +
            "You must include only the movies available on {{platform}}.")
    String generateMoviesSuggestion(@V("platform") String platform, @UserMessage String userMessage);
}
