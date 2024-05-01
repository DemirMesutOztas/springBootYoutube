package com.springBoot.Car.business.rules;

import com.springBoot.Car.core.BusinessException;
import com.springBoot.Car.dataAccess.abstracts.IBrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private IBrandRepository brandRepository;

   public void checkIfBrandNameExists(String name){

        if(this.brandRepository.existsByName(name)){
                throw new BusinessException("Brand name already exists!");
        }

    }

}
