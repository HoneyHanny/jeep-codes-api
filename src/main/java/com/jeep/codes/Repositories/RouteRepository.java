package com.jeep.codes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeep.codes.Models.RouteModel;

@Repository
public interface RouteRepository extends JpaRepository<RouteModel, Long> {
}
