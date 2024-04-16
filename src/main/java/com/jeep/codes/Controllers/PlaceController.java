package com.jeep.codes.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.jeep.codes.Models.PlaceModel;
import com.jeep.codes.Services.PlaceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public PlaceModel addPlace(@RequestBody PlaceModel place) {
        return placeService.addPlace(place);
    }

    @GetMapping("/get")
    public List<PlaceModel> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/get/{id}")
    public PlaceModel getPlace(@PathVariable long id) {
        return placeService.getPlace(id);
    }

    @PutMapping("/path/{id}")
    public PlaceModel updatePlace(@RequestBody PlaceModel place) {
        return placeService.updatePlace(place);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlace(@PathVariable long id) {
        placeService.deletePlace(id);
    }

}
