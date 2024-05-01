package com.springBoot.Car.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatModelRequest {

    @NotBlank
    @NotNull
    @Size(min = 0, max = 20)
    private String name;
    @NotBlank
    @NotNull
    private int brandId;

}
