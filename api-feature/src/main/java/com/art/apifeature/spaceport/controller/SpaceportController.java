package com.art.apifeature.spaceport.controller;

import com.art.apifeature.spaceport.dto.GetAllSpaceport;
import com.art.apifeature.spaceport.service.SpaceportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "spaceport-api", description = "Spaceport management APIs")
@RestController
@RequestMapping("/spaceport")
public class SpaceportController {

    private final SpaceportService spaceportService;

    @Autowired
    public SpaceportController(SpaceportService spaceportService) {
        this.spaceportService = spaceportService;
    }

    @Operation(
            summary = "Retrieve all spaceport",
            description = "Get all spaceport object by. The response is spaceport object",
            tags = {"spaceport", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = GetAllSpaceport.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public GetAllSpaceport getAllSpaceport() {
        return spaceportService.getAllSpaceport();
    }
}
