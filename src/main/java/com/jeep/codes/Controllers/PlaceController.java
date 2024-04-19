package com.jeep.codes.Controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.jeep.codes.DTOs.PlaceDTO;
import com.jeep.codes.Models.PlaceModel;
import com.jeep.codes.Services.PlaceService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/place")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping("/add")
    public ResponseEntity<PlaceModel> addPlace(@RequestBody PlaceModel place) {
        if (place == null)
            return ResponseEntity.badRequest().build();

        try {
            return ResponseEntity.ok(placeService.addPlace(place));
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<PlaceModel>> getAllPlaces() {
        try {
            return ResponseEntity.ok(placeService.getAllPlaces());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PlaceModel> getPlace(@PathVariable Long id) {
        if (id == null)
            return ResponseEntity.badRequest().build();

        try {
            return ResponseEntity.ok(placeService.getPlace(id));
        } catch (NoSuchElementException nse) {
            nse.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<PlaceModel> getPlace(@PathVariable String name) {
        if (name == null)
            return ResponseEntity.badRequest().build();

        try {
            return ResponseEntity.ok(placeService.getPlace(name));
        } catch (NoSuchElementException nse) {
            nse.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlaceModel> updatePlace(@PathVariable Long id, @RequestBody PlaceDTO place) {
        if (place == null)
            return ResponseEntity.badRequest().build();

        try {
            return ResponseEntity.ok(placeService.updatePlace(id, place));
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        if (id == null)
            return ResponseEntity.badRequest().build();

        try {
            placeService.deletePlace(id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException nse) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}
