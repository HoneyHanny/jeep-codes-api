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
        return routeRepository.addRoute(route);
    }

    public List<RouteModel> getAllRoutes() {
        return routeRepository.getAllRoutes();
    }

    public RouteModel getRoute(Long id) {
        return routeRepository.getRoute(id);
    }

    public RouteModel updateRoute(Long id, RouteModel route) {
        return routeRepository.updateRoute(id, route);
    }

    public RouteModel deleteRoute(Long id) {
        return routeRepository.deleteRoute(id);
    }

}
