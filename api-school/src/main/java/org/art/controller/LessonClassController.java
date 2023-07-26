package org.art.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.art.model.LessonClass;
import org.art.services.LessonClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "lesson-class-api", description = "LessonClass APIs")
@RestController
@RequestMapping("/classes")
public class LessonClassController {

    private final LessonClassService lessonClassService;

    @Autowired
    public LessonClassController(LessonClassService lessonClassService) {
        this.lessonClassService = lessonClassService;
    }

    @GetMapping("/id/{classLessonId}")
    @ResponseStatus(HttpStatus.OK)
    public LessonClass getLessonClassById(@PathVariable("classLessonId") Integer id) {
        return lessonClassService.getLessonClassById(id);
    }

    @GetMapping("/level/{classLevel}")
    @ResponseStatus(HttpStatus.OK)
    public List<LessonClass> getLessonClassByLevel(@PathVariable("classLevel") Integer id) {
        return lessonClassService.getLessonClassesByLevel(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<LessonClass> getLessonClass() {
        return lessonClassService.getAllLessonClasses();
    }
}
