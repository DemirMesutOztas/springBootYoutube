package com.springBoot.Car.business.concretes;

import com.springBoot.Car.business.abstracts.IModelService;
import com.springBoot.Car.business.requests.CreatModelRequest;
import com.springBoot.Car.business.responses.GetAllModelsResponse;
import com.springBoot.Car.core.ModelMapperService;
import com.springBoot.Car.dataAccess.abstracts.IModelRepository;
import com.springBoot.Car.entities.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService {

    private IModelRepository IModelRepository;
    ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAllModelsResponse() {
        List<Model> models = IModelRepository.findAll();
        List<GetAllModelsResponse> modelsResponses = models.stream().
                map(model -> this.modelMapperService.forResponse().
                map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponses;
    }

    @Override
    public void add(CreatModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().
                map(createModelRequest,Model.class);
        this.IModelRepository.save(model);
    }
}
