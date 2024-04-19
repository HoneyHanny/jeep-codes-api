package com.jeep.codes.Controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.jeep.codes.DTOs.RouteDTO;
import com.jeep.codes.Models.RouteModel;
import com.jeep.codes.Services.RouteService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/route")
public class RouteController {

    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/add")
    public ResponseEntity<RouteModel> addRoute(@RequestBody RouteModel route) {
        if (route == null)
            return ResponseEntity.badRequest().build();

        try {
            return ResponseEntity.ok(routeService.addRoute(route));
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<RouteModel>> getAllRoutes() {
        try {
            return ResponseEntity.ok(routeService.getAllRoutes());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RouteModel> getRoute(@PathVariable Long id) {
        if (id == null)
            return ResponseEntity.badRequest().build();

        try {
            return ResponseEntity.ok(routeService.getRoute(id));
        } catch (NoSuchElementException nse) {
            nse.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/get/code/{code}")
    public ResponseEntity<RouteModel> getRoute(@PathVariable String code) {
        if (code == null)
            return ResponseEntity.badRequest().build();

        try {
            return ResponseEntity.ok(routeService.getRoute(code));
        } catch (NoSuchElementException nse) {
            nse.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RouteModel> updateRoute(@PathVariable Long id, @RequestBody RouteDTO route) {
        if (route == null)
            return ResponseEntity.badRequest().build();

        try {
            return ResponseEntity.ok(routeService.updateRoute(id, route));
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        if (id == null)
            return ResponseEntity.badRequest().build();

        try {
            routeService.deleteRoute(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException nse) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}
