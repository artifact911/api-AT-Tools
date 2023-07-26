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
import org.art.model.Teacher;
import org.art.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "teacher-api", description = "Teacher APIs")
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Operation(
            summary = "Retrieve a Teacher by Id",
            description = "Get a Teacher object by specifying its id. The response is Teacher object",
            tags = {"teacher", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Teacher.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "The Teacher with given Id was not found.", content = {@Content(schema = @Schema())})
    })
    @GetMapping("/id/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public Teacher getTeacherById(
            @Parameter(description = "Search Teacher by Id", required = true) @PathVariable("teacherId") Integer id) {
        return teacherService.getTeacherById(id);
    }

    @Operation(
            summary = "Retrieve all Teachers",
            description = "Get all Teachers list.",
            tags = {"teacher", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Teacher.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "The TeacherList was not found.", content = {@Content(schema = @Schema())})
    })
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getAllTeachers() {
        return teacherService.getAll();
    }

    @Operation(
            summary = "Retrieve all Teachers by technology",
            description = "Get all Teachers by technology. The response is Teacher object",
            tags = {"teacher", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Teacher.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "The TeacherList by technology was not found.", content = {@Content(schema = @Schema())})
    })
    @Parameters({
            @Parameter(name = "technology", description = "Get All Teachers by technology", required = true)
    })
    @GetMapping("/technology")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getTeachersByTechnology(@RequestParam("technology") String technology) {
        return teacherService.getTeachersByTechnology(technology);
    }
}
