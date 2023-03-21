package org.art.controller;

import org.art.model.City;
import org.art.model.HelloWorld;
import org.art.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController (CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public ResponseEntity<?> hi() {
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Hello World!");
        HelloWorld helloWorld = new HelloWorld("Hello from pupils!");
        return ResponseEntity.ok(helloWorld);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getCities() {

        try {
            return ResponseEntity.ok(cityService.getAllCities());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/id/{cityId}")
    @ResponseStatus(HttpStatus.OK)
    public City getCityById(@PathVariable("cityId") Integer id) {
        return cityService.getCityById(id);
    }
}
