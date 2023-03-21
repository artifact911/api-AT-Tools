package org.art.controller;

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

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/id/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public Teacher getTeacherById(@PathVariable("teacherId") Integer id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getAllTeachers() {
        return teacherService.getAll();
    }

    @GetMapping("/technology")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getTeachersByTechnology(@RequestParam("technology") String technology) {
        return teacherService.getTeachersByTechnology(technology);
    }
}
