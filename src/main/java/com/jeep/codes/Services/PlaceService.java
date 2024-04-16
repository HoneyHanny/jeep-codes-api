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
        return placeRepository.save(place);
    }

    public List<PlaceModel> getAllPlaces() {
        return placeRepository.findAll();
    }

    public PlaceModel getPlace(Long id) {
        return placeRepository.getReferenceById(id);
    }

    public PlaceModel updatePlace(PlaceModel newPlace) {
        PlaceModel oldPlace = placeRepository.findById(newPlace.getPlaceId()).orElseThrow();

        oldPlace.setName(newPlace.getName());

        return placeRepository.save(oldPlace);
    }

    public void deletePlace(Long id) {
        PlaceModel place = placeRepository.findById(id).orElseThrow();

        placeRepository.delete(place);
    }

}
