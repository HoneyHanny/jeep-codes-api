package com.jeep.codes.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.jeep.codes.Models.RouteModel;
import com.jeep.codes.Services.RouteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/route/")
public class RouteController {

    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("add")
    public RouteModel addRoute(@RequestBody RouteModel route) {
        return routeService.addRoute(route);
    }

    @GetMapping("get")
    public List<RouteModel> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("get/{id}")
    public RouteModel getRoute(@PathVariable Long id) {
        return routeService.getRoute(id);
    }

    @PutMapping("update/{id}")
    public RouteModel updateRoute(@PathVariable Long id, @RequestBody RouteModel route) {
        return routeService.updateRoute(id, route);
    }

    @DeleteMapping("delete/{id}")
    public RouteModel deleteRoute(@PathVariable Long id) {
        return routeService.deleteRoute(id);
    }

}
