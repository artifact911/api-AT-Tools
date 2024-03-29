package org.art.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.art.model.School;
import org.art.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "school-api", description = "School APIs")
@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getSchoolById() {
        return "Hello from SchoolController!";
    }

    @GetMapping("/id/{schoolId}")
    @ResponseStatus(HttpStatus.OK)
    public School getSchoolById(@PathVariable("schoolId") Integer id) {
        return schoolService.getSchoolById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<School> getAllSchools() {
        return schoolService.getAll();
    }
}
