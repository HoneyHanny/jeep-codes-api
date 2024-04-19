package com.jeep.codes.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {

    private String code;

    private List<String> places;

    public RouteDTO(String code) {
        this.code = code;
    }

}
