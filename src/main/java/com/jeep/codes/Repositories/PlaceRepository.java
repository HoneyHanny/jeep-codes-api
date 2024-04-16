package com.jeep.codes.Repositories;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jeep.codes.Models.PlaceModel;

@Repository
@Component
public class PlaceRepository {

    // Get the data using database context

    public PlaceModel addPlace(PlaceModel place) {
        return place;
    }

    public List<PlaceModel> getAllPlaces() {
        return null;
    }

    public PlaceModel getPlace(Long id) {
        return null;
    }

    public PlaceModel updatePlace(Long id, PlaceModel place) {
        return null;
    }

    public PlaceModel deletePlace(Long id) {
        return null;
    }

}
