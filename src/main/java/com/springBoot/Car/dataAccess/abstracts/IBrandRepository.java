package com.springBoot.Car.dataAccess.abstracts;

import com.springBoot.Car.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name); //spring jpa keywords kelimelerden kendi üretiyor

}
