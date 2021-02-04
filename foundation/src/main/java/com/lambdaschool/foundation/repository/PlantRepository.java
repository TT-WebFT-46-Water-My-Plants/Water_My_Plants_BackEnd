package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.Plant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PlantRepository extends CrudRepository<Plant, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE plants SET nickname = :nickname, last_modified_by = :uname, species = :species, h2oFrequency = :h2oFrequency, last_modified_date = CURRENT_TIMESTAMP WHERE plantid = :plantid",
    nativeQuery = true)
    void updatePlantName(
            String uname,
            String nickname,
            long plantid,
            String species,
            Integer h2oFrequency);
}
