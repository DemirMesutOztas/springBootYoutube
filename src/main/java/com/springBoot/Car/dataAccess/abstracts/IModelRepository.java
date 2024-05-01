package com.springBoot.Car.dataAccess.abstracts;

import com.springBoot.Car.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModelRepository extends JpaRepository<Model,Integer> {

}
