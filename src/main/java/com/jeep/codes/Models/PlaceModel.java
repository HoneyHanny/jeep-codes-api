package com.jeep.codes.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PlaceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "name")
    private String name;

    PlaceModel(Long placeId, String name) {
        this.placeId = placeId;
        this.name = name;
    }

    PlaceModel(String name) {
        this.name = name;
    }

}
