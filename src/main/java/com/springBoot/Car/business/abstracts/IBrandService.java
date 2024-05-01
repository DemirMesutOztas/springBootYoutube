package com.springBoot.Car.business.abstracts;

import com.springBoot.Car.business.requests.CreateBrandRequest;
import com.springBoot.Car.business.requests.UpdateBrandRequest;
import com.springBoot.Car.business.responses.GetAllBrandsResponse;
import com.springBoot.Car.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface IBrandService {

    List<GetAllBrandsResponse> getBrandService();
    void add(CreateBrandRequest createBrandRequest);
    GetByIdBrandResponse getByIdBrandResponse(int id);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);


}
