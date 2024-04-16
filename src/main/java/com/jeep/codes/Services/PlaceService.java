package com.jeep.codes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeep.codes.Models.PlaceModel;
import com.jeep.codes.Repositories.PlaceRepository;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public PlaceModel addPlace(PlaceModel place) {
        return placeRepository.addPlace(place);
    }

    public List<PlaceModel> getAllPlaces() {
        return placeRepository.getAllPlaces();
    }

    public PlaceModel getPlace(Long id) {
        return placeRepository.getPlace(id);
    }

    public PlaceModel updatePlace(Long id, PlaceModel place) {
        return placeRepository.updatePlace(id, place);
    }

    public PlaceModel deletePlace(Long id) {
        return placeRepository.deletePlace(id);
    }

}
