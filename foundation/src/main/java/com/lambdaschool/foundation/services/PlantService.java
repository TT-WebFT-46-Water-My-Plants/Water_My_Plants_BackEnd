package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Plant;

import java.util.List;

public interface PlantService {
    List<Plant> findAll();

    Plant save(Plant plant);
}
