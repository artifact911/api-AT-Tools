package org.art.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.art.common.Api;
import org.art.dto.city.CreateUpdateCityReqBody;
import org.art.model.City;
import org.art.model.HelloWorld;
import org.art.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.art.helpers.response.RespEntityHelper.getErrorResp;
import static org.art.helpers.response.RespEntityHelper.getSuccessResp;

@Tag(name = "city-api", description = "City APIs")
@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<?> hi() {
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Hello World!");
        HelloWorld helloWorld = new HelloWorld(Api.CITY_API);
        return ResponseEntity.ok(helloWorld);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<City> allCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/id/{cityId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> cityById(@PathVariable("cityId") Integer id) {
        try {
            return ResponseEntity.ok(cityService.getCityById(id));
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.GET, Api.CITY_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/create/new")
    public ResponseEntity<?> newCity(@RequestBody CreateUpdateCityReqBody body) {
        try {
            Integer newCityId = cityService.createCity(body);
            return getSuccessResp(HttpStatus.CREATED, String.format("City: Created with id: %s", newCityId));
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.POST, Api.CITY_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PatchMapping("/id/{cityId}/patch")
    public ResponseEntity<?> editCity(@PathVariable("cityId") Integer id,
                                      @RequestBody CreateUpdateCityReqBody body) {
        try {
            Integer patchedCityId = cityService.patchCity(id, body);
            return getSuccessResp(HttpStatus.OK, String.format("City: Patched with id: %s", patchedCityId));
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.PATCH, Api.CITY_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/id/{cityId}/put")
    public ResponseEntity<?> putCity(@PathVariable("cityId") Integer id,
                                     @RequestBody CreateUpdateCityReqBody body) {
        try {
            Integer putCityId = cityService.putCity(id, body);
            return getSuccessResp(HttpStatus.OK, String.format("City: Put with id: %s", putCityId));
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.PUT, Api.CITY_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/id/{cityId}/delete")
    public ResponseEntity<?> deleteCity(@PathVariable("cityId") Integer id) {
        try {
            cityService.deleteCity(id);
            return getSuccessResp(HttpStatus.OK, String.format("City: Deleted with id: %s", id));
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.DELETE, Api.CITY_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
