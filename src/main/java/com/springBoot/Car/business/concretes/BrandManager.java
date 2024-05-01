package com.springBoot.Car.business.concretes;

import com.springBoot.Car.business.abstracts.IBrandService;
import com.springBoot.Car.business.requests.CreateBrandRequest;
import com.springBoot.Car.business.requests.UpdateBrandRequest;
import com.springBoot.Car.business.responses.GetAllBrandsResponse;
import com.springBoot.Car.business.responses.GetByIdBrandResponse;
import com.springBoot.Car.business.rules.BrandBusinessRules;
import com.springBoot.Car.core.ModelMapperService;
import com.springBoot.Car.dataAccess.abstracts.IBrandRepository;
import com.springBoot.Car.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BrandManager implements IBrandService {

    IBrandRepository brandRepository;
    ModelMapperService modelMapperService;
    BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getBrandService() {

        List<Brand> brands = this.brandRepository.findAll();

       List<GetAllBrandsResponse> brandsResponse = brands.stream().
                map(brand -> this.modelMapperService.forResponse().
                map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getByIdBrandResponse(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.
                forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }
}
