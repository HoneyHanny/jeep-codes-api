package com.jeep.codes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeep.codes.Models.RouteModel;
import com.jeep.codes.Repositories.RouteRepository;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public RouteModel addRoute(RouteModel route) {
        return routeRepository.save(route);
    }

    public List<RouteModel> getAllRoutes() {
        return routeRepository.findAll();
    }

    public RouteModel getRoute(Long id) {
        return routeRepository.getReferenceById(id);
    }

    public RouteModel updateRoute(RouteModel newRoute) {
        RouteModel oldRoute = routeRepository.findById(newRoute.getRouteId()).orElseThrow();

        oldRoute.setCode(newRoute.getCode());

        return routeRepository.save(oldRoute);
    }

    public void deleteRoute(Long id) {
        RouteModel place = routeRepository.findById(id).orElseThrow();

        routeRepository.delete(place);
    }

}
