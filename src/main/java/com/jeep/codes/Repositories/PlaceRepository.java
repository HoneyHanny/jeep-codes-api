package com.jeep.codes.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeep.codes.Models.PlaceModel;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceModel, Long> {

    Optional<PlaceModel> findByName(String name);
}
