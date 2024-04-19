package com.jeep.codes.Services;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeep.codes.DTOs.PlaceDTO;
import com.jeep.codes.Models.PlaceModel;
import com.jeep.codes.Models.RouteModel;
import com.jeep.codes.Repositories.PlaceRepository;
import com.jeep.codes.Repositories.RouteRepository;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private RouteRepository routeRepository;

    PlaceService(PlaceRepository placeRepository, RouteRepository routeRepository) {
        this.placeRepository = placeRepository;
        this.routeRepository = routeRepository;
    }

    public PlaceModel addPlace(PlaceModel place) throws IllegalArgumentException {
        try {
            getPlace(place.getName());
            throw new IllegalArgumentException("The place " + place.getName() + " already exist.");
        } catch (NoSuchElementException nse) {
            Set<RouteModel> routeSet = new HashSet<>();
            for (RouteModel route : place.getRoutes())
                routeSet.add(routeRepository.findByCode(route.getCode()).orElse(new RouteModel(route.getCode())));
            place.getRoutes().clear();
            place.setRoutes(routeSet);

            return placeRepository.save(place);
        }
    }

    public List<PlaceModel> getAllPlaces() {
        return placeRepository.findAll();
    }

    public PlaceModel getPlace(Long id) throws NoSuchElementException {
        return placeRepository.findById(id).orElseThrow();
    }

    public PlaceModel getPlace(String name) throws NoSuchElementException {
        return placeRepository.findByName(name).orElseThrow();

    }

    public PlaceModel updatePlace(Long id, PlaceDTO newPlace) throws IllegalArgumentException {
        Optional<PlaceModel> oldPlaceOptional = placeRepository.findById(id);

        Set<RouteModel> routesSet = new HashSet<>();
        for (String code : newPlace.getRoutes()) {
            routesSet.add(routeRepository.findByCode(code).orElse(new RouteModel(code)));
        }

        PlaceModel newPlaceModel = new PlaceModel(newPlace.getName(), routesSet);

        Optional<PlaceModel> tempOptional = placeRepository.findByName(newPlaceModel.getName());
        if (!oldPlaceOptional.isPresent()) {
            if (tempOptional.isPresent()) {
                PlaceModel temp = tempOptional.get();
                if (newPlaceModel.getName().equals(temp.getName()))
                    throw new IllegalArgumentException("Another place with the name already exist");
            }
            return placeRepository.save(newPlaceModel);
        }

        PlaceModel oldPlace = oldPlaceOptional.get();
        if (tempOptional.isPresent()) {
            PlaceModel temp = tempOptional.get();
            if (temp.getName().equals(newPlaceModel.getName())
                    && temp.getPlaceId() != oldPlace.getPlaceId())
                throw new IllegalArgumentException("Another place with the name already exist");
        }
        oldPlace.setName(newPlaceModel.getName());
        oldPlace.getRoutes().clear();
        oldPlace.setRoutes(newPlaceModel.getRoutes());

        return placeRepository.save(oldPlace);
    }

    public void deletePlace(Long id) throws NoSuchElementException {
        PlaceModel place = placeRepository.findById(id).orElseThrow();

        placeRepository.delete(place);
    }

}
