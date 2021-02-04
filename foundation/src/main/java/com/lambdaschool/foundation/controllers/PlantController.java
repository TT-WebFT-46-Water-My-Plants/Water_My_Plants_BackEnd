package com.lambdaschool.foundation.controllers;


import com.lambdaschool.foundation.models.Plant;
import com.lambdaschool.foundation.models.Role;
import com.lambdaschool.foundation.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {
    @Autowired
    private PlantService plantService;


    @GetMapping(value = "/plants",
            produces = "application/json")
    public ResponseEntity<?> listPlants()
    {
        List<Plant> allPlants = plantService.findAll();
        return new ResponseEntity<>(allPlants,
                HttpStatus.OK);
    }
    @GetMapping(value = "/plant/{plantId}",
    produces = "application/json")
    public ResponseEntity<?> getPlantById(
            @PathVariable Long plantId){
        Plant p = plantService.findPlantById(plantId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping(value = "/plant",
            consumes = "application/json")
    public ResponseEntity<?> addNewPlant(
            @Valid
            @RequestBody
                    Plant newPlant)
    {
        // ids are not recognized by the Post method
        newPlant.setPlantid(0);
        newPlant = plantService.save(newPlant);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPlantURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{plantid}")
                .buildAndExpand(newPlant.getPlantid())
                .toUri();
        responseHeaders.setLocation(newPlantURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/plant/{plantid}",
    consumes = {"application/json"})
    public ResponseEntity<?> putUpdatePlant(
            @PathVariable long plantid,
            @Valid
            @RequestBody Plant newPlant)
    {
        newPlant = plantService.update(plantid, newPlant);
                return new ResponseEntity<>(HttpStatus.OK);
    }
}
