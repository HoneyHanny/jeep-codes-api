package com.jeep.codes.Repositories;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jeep.codes.Models.RouteModel;

@Repository
@Component
public class RouteRepository {

    // Get the data using database context

    public RouteModel addRoute(RouteModel route) {
        return route;
    }

    public List<RouteModel> getAllRoutes() {
        return null;
    }

    public RouteModel getRoute(Long id) {
        return null;
    }

    public RouteModel updateRoute(Long id, RouteModel route) {
        return null;
    }

    public RouteModel deleteRoute(Long id) {
        return null;
    }

}
