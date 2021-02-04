package com.lambdaschool.foundation.services;


import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "plantService")
public class PlantServiceImpl implements PlantService{

    @Autowired
    private PlantRepository plantrepos;


    @Override
    public List<Plant> findAll() {
        List<Plant> list = new ArrayList<>();

        plantrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Plant save(Plant plant) {
        if (plant.getUsers()
        .size() > 0 )
        {
            throw new ResourceNotFoundException("Users Plants was not Updated.");
        }
        return plantrepos.save(plant);

    }

    @Override
    public Plant findPlantById(Long id) {
        return plantrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plant id: " + id + "Not Found!"));
    }
}
