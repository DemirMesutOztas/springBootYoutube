package com.springBoot.Car.business.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationDetails extends ProblemDetails {
    private Map<String,String> validationErrors;

}
