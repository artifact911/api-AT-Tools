package com.art.apifeature.controller;

import com.art.apifeature.dto.GetAllSpaceport;
import com.art.apifeature.service.SpaceportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spaceport")
public class SpaceportController {

    private final SpaceportService spaceportService;

    @Autowired
    public SpaceportController(SpaceportService spaceportService) {
        this.spaceportService = spaceportService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public GetAllSpaceport getAllSpaceport() {
        return spaceportService.getAllSpaceport();
    }
}
