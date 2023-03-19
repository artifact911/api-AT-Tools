package org.art.controller;

import org.art.model.HelloWorld;
import org.art.model.School;
import org.art.services.SchoolServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolControllerOld {

    private final SchoolServiceOld schoolService;

    @Autowired
    public SchoolControllerOld(SchoolServiceOld schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/")
    public ResponseEntity<?> hi() {
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Hello World!");
        HelloWorld helloWorld = new HelloWorld("Hello from schools!");
        return ResponseEntity.ok(helloWorld);
    }

    @GetMapping("/schools")
    public ResponseEntity<?> getSchools(){
       try {
           List<School> schools = schoolService.getSchools();
           return ResponseEntity.ok(schools);
       } catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/schoolId")
    public ResponseEntity<?> getSchool(@RequestParam("idSchool") int idSchool) {
        try {
            return ResponseEntity.ok(schoolService.getSchool(idSchool));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }
}

