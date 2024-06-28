package com.springai.spring_ai.ai.service;


import java.util.List;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springai.spring_ai.ai.entity.SpringAi;
import com.springai.spring_ai.ai.model.AiResponseModel;
import com.springai.spring_ai.ai.repository.SpringAiRepository;

@Service
public class SpringAiServiceImpl implements SpringAiService {

    @Autowired
    private ChatModel chatModel;

    @Autowired
    private SpringAiRepository springAiRepository;

    @Override
    public AiResponseModel getAIResponseByPrompt(String prompt) {
        SpringAi springAi = new SpringAi();
        springAi.setPropmt(prompt);

        UserMessage userMessage = new UserMessage(prompt);
        Prompt promptObject = new Prompt(List.of(userMessage), OpenAiChatOptions.builder().build());

        ChatResponse response = chatModel.call(promptObject);

        if (response != null && response.getResult() != null) {
            String apiResponse = response.getResult().getMetadata().getContentFilterMetadata();
            springAi.setApiResponse(apiResponse);
        } else {
            springAi.setApiResponse("No response from AI");
        }

        SpringAi savedSpringAi = springAiRepository.save(springAi);
        AiResponseModel aiResponseModel = new AiResponseModel();
        aiResponseModel.setApiResponse(savedSpringAi.getApiResponse());
        aiResponseModel.setPrompt(prompt);
        aiResponseModel.setCreatedAt(savedSpringAi.getCreatedAt());
        aiResponseModel.setId(savedSpringAi.getId());
        return aiResponseModel;
    }
    
}
