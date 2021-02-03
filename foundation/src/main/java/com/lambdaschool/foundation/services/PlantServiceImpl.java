package com.lambdaschool.foundation.services;


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

    @Autowired
    private PlantService plantService;

    @Autowired
    private HelperFunctions helperFunctions;

    @Override
    public List<Plant> findAll() {
        List<Plant> list = new ArrayList<>();

        plantrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
