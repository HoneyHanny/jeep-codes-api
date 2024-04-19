package com.jeep.codes.DTOs;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDTO {

    private String name;

    private Set<String> routes;

    public PlaceDTO(String name) {
        this.name = name;
    }

}
