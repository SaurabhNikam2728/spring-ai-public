package com.springai.spring_ai.ai.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springai.spring_ai.ai.constants.Constants;
import com.springai.spring_ai.ai.model.AiResponseModel;
import com.springai.spring_ai.ai.service.SpringAiService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(Constants.AI)
public class SpringAiController {

    @Autowired
    private SpringAiService springAiService;

    @PostMapping
    public ResponseEntity<AiResponseModel> sendPromtAndGetResponse(@RequestBody String prompt)
    {
        AiResponseModel response=springAiService.getAIResponseByPrompt(prompt);
        return ResponseEntity.ok().body(response);
    }
}
