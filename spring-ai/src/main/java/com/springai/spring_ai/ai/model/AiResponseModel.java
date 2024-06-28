package com.springai.spring_ai.ai.model;

import java.util.Date;

import lombok.Data;

@Data
public class AiResponseModel {

    private Integer id;

    private Date createdAt;

    private String prompt;

    private String apiResponse;
}
