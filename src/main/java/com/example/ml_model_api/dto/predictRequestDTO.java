package com.example.ml_model_api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class predictRequestDTO {

    private double age;
    private double salary;
}
