package com.example.ml_model_api.controller;

import com.example.ml_model_api.dto.predictResponseDTO;
import com.example.ml_model_api.dto.predictRequestDTO;
import com.example.ml_model_api.service.impl.predictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class predictController {

    @Autowired
    private predictServiceImpl predictService;

    @PostMapping("/predict")
    public predictResponseDTO predict(@RequestBody predictRequestDTO request) {
        return predictService.getPrediction(request);
    }
}
