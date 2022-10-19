package org.art.controller;

import org.art.model.Pupil;
import org.art.model.School;
import org.art.repository.PupilService;
import org.art.repository.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class Controller {

    private final SchoolService schoolService;

    private final PupilService pupilService;

   @Autowired
    public Controller(SchoolService schoolService, PupilService pupilService) {
        this.schoolService = schoolService;
        this.pupilService = pupilService;
    }

    @GetMapping("/")
    public ResponseEntity<?> hi() {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Hello World!");
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

    @GetMapping("/school")
    public ResponseEntity<?> getSchool(@RequestParam("idSchool") int idSchool) {
        try {
            return ResponseEntity.ok(schoolService.getSchool(idSchool));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/pupils")
    public ResponseEntity<?> getPupils(@RequestParam("idSchool") int idSchool) {
        try {
            return ResponseEntity.ok(pupilService.getPupils(idSchool));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/pupil")
    public ResponseEntity<?> getPupil(@RequestParam("idSchool") int idSchool, @RequestParam("idPupil") int idPupil) {
        try {
            return ResponseEntity.ok(pupilService.getPupil(idSchool, idPupil));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }

    @DeleteMapping("/pupil/del")
    public ResponseEntity<?> delPupil(@RequestParam("idSchool") int idSchool, @RequestParam("idPupil") int idPupil) {
        try {
            return ResponseEntity.ok(pupilService.delPupil(idSchool, idPupil));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }

    @PostMapping("/pupil/add")
    public ResponseEntity<?> addPupil(@RequestParam("idSchool") int idSchool, @RequestBody Pupil pupil) {
        try {
            List<Pupil> newList = pupilService.postPupil(idSchool, pupil);
            return ResponseEntity.ok(pupilService.getPupils(idSchool));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }

    @PutMapping ("/pupil/edit")
    public ResponseEntity<?> editPupil(@RequestParam("idSchool") int idSchool, @RequestParam("idPupil") int idPupil,
                                      @RequestBody Pupil pupil) {
        try {
            return ResponseEntity.ok(pupilService.editPupil(idSchool, idPupil, pupil));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }
}

