package com.example.ml_model_api.service;

import com.example.ml_model_api.dto.predictRequestDTO;
import com.example.ml_model_api.dto.predictResponseDTO;


public interface predictService {
    predictResponseDTO getPrediction(predictRequestDTO request);
}



