package com.springai.spring_ai.ai.service;

import com.springai.spring_ai.ai.model.AiResponseModel;

public interface SpringAiService {
    AiResponseModel getAIResponseByPrompt(String prompt);
}
