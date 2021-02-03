package com.lambdaschool.foundation.controllers;


import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/plants",
            produces = "application/json")
            public ResponseEntity<?> listAllPlants(){
        List<Plant> myPlants = plantService.findAll();

        System.out.println(SecurityContextHolder.getContext()
        .getAuthentication().getName());

        return new ResponseEntity<>(myPlants, HttpStatus.OK);
    }
}
