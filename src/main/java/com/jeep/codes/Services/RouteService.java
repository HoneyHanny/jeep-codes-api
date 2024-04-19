package com.jeep.codes.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeep.codes.DTOs.RouteDTO;
import com.jeep.codes.Models.PlaceModel;
import com.jeep.codes.Models.RouteModel;
import com.jeep.codes.Repositories.PlaceRepository;
import com.jeep.codes.Repositories.RouteRepository;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PlaceRepository placeRepository;

    RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public RouteModel addRoute(RouteModel route) throws IllegalArgumentException {
        try {
            getRoute(route.getCode());
            throw new IllegalArgumentException("The place " + route.getCode() + " already exist.");
        } catch (NoSuchElementException nse) {
            return routeRepository.save(route);
        }
    }

    public List<RouteModel> getAllRoutes() {
        return routeRepository.findAll();
    }

    public RouteModel getRoute(Long id) throws NoSuchElementException {
        return routeRepository.findById(id).orElseThrow();
    }

    public RouteModel getRoute(String code) throws NoSuchElementException {
        return routeRepository.findByCode(code).orElseThrow();
    }

    public RouteModel updateRoute(Long id, RouteDTO newRoute) throws IllegalArgumentException {
        Optional<RouteModel> oldRouteOptional = routeRepository.findById(id);

        List<PlaceModel> placesList = new ArrayList<>();
        for (String name : newRoute.getPlaces()) {
            placesList.add(placeRepository.findByName(name).orElse(new PlaceModel(name)));
        }

        RouteModel newRouteModel = new RouteModel(newRoute.getCode(), placesList);

        Optional<RouteModel> tempOptional = routeRepository.findByCode(newRouteModel.getCode());
        if (!oldRouteOptional.isPresent()) {
            if (tempOptional.isPresent()) {
                RouteModel temp = tempOptional.get();
                if (newRouteModel.getCode().equals(temp.getCode()))
                    throw new IllegalArgumentException("Value already exist");
            }

            return routeRepository.save(newRouteModel);
        }

        RouteModel oldRoute = oldRouteOptional.get();
        if (tempOptional.isPresent()) {
            RouteModel temp = tempOptional.get();
            if (temp.getCode().equals(newRouteModel.getCode())
                    && temp.getRouteId() != oldRoute.getRouteId())
                throw new IllegalArgumentException("Value already exists");
        }
        oldRoute.setCode(newRouteModel.getCode());
        oldRoute.setPlaces(newRouteModel.getPlaces());

        return routeRepository.save(oldRoute);
    }

    public void deleteRoute(Long id) throws NoSuchElementException {
        RouteModel place = routeRepository.findById(id).orElseThrow();

        routeRepository.delete(place);
    }

}
