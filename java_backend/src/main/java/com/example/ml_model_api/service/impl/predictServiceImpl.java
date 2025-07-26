package com.example.ml_model_api.service.impl;

import com.example.ml_model_api.dto.predictRequestDTO;
import com.example.ml_model_api.dto.predictResponseDTO;
import com.example.ml_model_api.service.predictService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//service class
@Service
public class predictServiceImpl implements predictService {
    public final String PYTHON_API = "http://python_ml:8000/predict";

    @Override
    public predictResponseDTO getPrediction(predictRequestDTO request) {
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var entity = new HttpEntity<predictRequestDTO>(request,headers);

        var response = restTemplate.postForEntity(PYTHON_API,entity, predictResponseDTO.class);

        return response.getBody();
    }
}
