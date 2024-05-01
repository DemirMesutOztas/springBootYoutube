package com.springBoot.Car.api;

import com.springBoot.Car.business.abstracts.IModelService;
import com.springBoot.Car.business.requests.CreatModelRequest;
import com.springBoot.Car.business.responses.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {

    private IModelService IModelService;
    @GetMapping()
    public List<GetAllModelsResponse> getBrandController()
    {
        return IModelService.getAllModelsResponse();
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED) //kod 201 gösterilmesi sağlanacak
    public void add(@RequestBody @Valid CreatModelRequest creatModelRequest)
    {

        this.IModelService.add(creatModelRequest);
    }

}
