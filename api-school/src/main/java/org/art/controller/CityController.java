package org.art.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.art.common.Api;
import org.art.dto.city.CreateUpdateCityReqBody;
import org.art.helpers.response.ErrorRes;
import org.art.helpers.response.SuccessRes;
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

    @Operation(
            summary = "Retrieve HI",
            description = "Get HelloWorld from CityController",
            tags = {"city", "hi"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = HelloWorld.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "The Teacher with given Id was not found.",
                    content = {@Content(schema = @Schema())})
    })
    @GetMapping
    public ResponseEntity<?> hi() {
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Hello World!");
        HelloWorld helloWorld = new HelloWorld(Api.CITY_API);
        return ResponseEntity.ok(helloWorld);
    }

    @Operation(
            summary = "Retrieve all cities",
            description = "Get CityList",
            tags = {"city", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(array = @ArraySchema(schema = @Schema(implementation = City.class)),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    content = {@Content(schema = @Schema(implementation = ErrorRes.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Path not found",
                    content = {@Content(schema = @Schema())})
    })
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<City> allCities() {
        return cityService.getAllCities();
    }

    @Operation(
            summary = "Retrieve City by Id",
            description = "Get the City",
            tags = {"city", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = City.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    content = {@Content(schema = @Schema(implementation = ErrorRes.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Path not found",
                    content = {@Content(schema = @Schema())})
    })
    @GetMapping("/id/{cityId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> cityById(
            @Parameter(description = "Search City by Id", required = true)
            @PathVariable("cityId") Integer id) {
        try {
            return ResponseEntity.ok(cityService.getCityById(id));
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.GET, Api.CITY_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Operation(
            summary = "Create new City",
            description = "Create City",
            tags = {"city", "post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = SuccessRes.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    content = {@Content(schema = @Schema(implementation = ErrorRes.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Path not found",
                    content = {@Content(schema = @Schema())})
    })
    @Parameters({
            @Parameter(content = @Content(schema = @Schema(implementation = CreateUpdateCityReqBody.class)),
                    required = true)
    })
    @PostMapping("/create/new")
    public ResponseEntity<?> newCity(@RequestBody CreateUpdateCityReqBody body) {
        try {
            Integer newCityId = cityService.createCity(body);
            return getSuccessResp(HttpStatus.CREATED, String.format("City: Created with id: %s", newCityId));
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.POST, Api.CITY_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Operation(
            summary = "Edit part of City by Id",
            description = "Patch City",
            tags = {"city", "patch"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = SuccessRes.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    content = {@Content(schema = @Schema(implementation = ErrorRes.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Path not found",
                    content = {@Content(schema = @Schema())})
    })
    @Parameters({
            @Parameter(description = "IdCity to edit",
                    content = @Content(schema = @Schema(implementation = Integer.class)),
                    required = true),
            @Parameter(content = @Content(schema = @Schema(implementation = CreateUpdateCityReqBody.class)),
                    required = true)
    })
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

    @Operation(
            summary = "Edit part of City by Id",
            description = "Put City",
            tags = {"city", "put"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = SuccessRes.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    content = {@Content(schema = @Schema(implementation = ErrorRes.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Path not found",
                    content = {@Content(schema = @Schema())})
    })
    @Parameters({
            @Parameter(description = "IdCity to edit",
                    content = @Content(schema = @Schema(implementation = Integer.class)),
                    required = true),
            @Parameter(content = @Content(schema = @Schema(implementation = CreateUpdateCityReqBody.class)),
                    required = true)
    })
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

    @Operation(
            summary = "Delete City by Id",
            description = "Delete City",
            tags = {"city", "delete"})
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = SuccessRes.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    content = {@Content(schema = @Schema(implementation = ErrorRes.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Path not found",
                    content = {@Content(schema = @Schema())})
    })
    @Parameters({
            @Parameter(description = "IdCity to delete",
                    content = @Content(schema = @Schema(implementation = Integer.class)),
                    required = true)
    })
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
