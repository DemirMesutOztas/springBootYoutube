package com.springBoot.Car;

import com.springBoot.Car.business.rules.ProblemDetails;
import com.springBoot.Car.business.rules.ValidationDetails;
import com.springBoot.Car.core.BusinessException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice // BÜTÜN CONTROLLER EXCEPTİONHANDLERA TABİİ
@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {

		SpringApplication.run(CarApplication.class, args);

	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException)
	{
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());

		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(MethodArgumentNotValidException methodArgumentNotValidException)
	{
		ValidationDetails validationDetails = new ValidationDetails();
		validationDetails.setMessage("Validation error!");
		validationDetails.setValidationErrors(new HashMap<String,String>());
		for (FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors())
		{

			validationDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		
		return validationDetails;
	}

	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}



}
