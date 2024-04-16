package com.jeep.codes.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RouteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "code")
    private String code;

    public RouteModel(Long routeId, String code) {
        this.routeId = routeId;
        this.code = code;
    }

    public RouteModel(String code) {
        this.code = code;
    }

}
