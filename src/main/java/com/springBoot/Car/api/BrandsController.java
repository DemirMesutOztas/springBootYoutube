package com.springBoot.Car.api;

import com.springBoot.Car.business.abstracts.IBrandService;
import com.springBoot.Car.business.requests.CreateBrandRequest;
import com.springBoot.Car.business.requests.UpdateBrandRequest;
import com.springBoot.Car.business.responses.GetAllBrandsResponse;
import com.springBoot.Car.business.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {

    private IBrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getBrandController()
    {
        return brandService.getBrandService();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id)
    {
        return brandService.getByIdBrandResponse(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED) //kod 201 gösterilmesi sağlanacak
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest)
    {

        this.brandService.add(createBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        this.brandService.delete(id);
    }

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest )
    {
        this.brandService.update(updateBrandRequest);
    }

}
