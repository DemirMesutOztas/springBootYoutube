package com.springBoot.Car.business.abstracts;

import com.springBoot.Car.business.requests.CreatModelRequest;
import com.springBoot.Car.business.responses.GetAllModelsResponse;

import java.util.List;

public interface IModelService {
    List<GetAllModelsResponse> getAllModelsResponse();
    void add(CreatModelRequest createModelRequest);
}
