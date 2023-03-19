package org.art.controller;

import org.art.model.HelloWorld;
import org.art.model.Pupil;
import org.art.services.PupilServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pupil")
public class PupilControllerOld {

    private final PupilServiceOld pupilService;

    @Autowired
    public PupilControllerOld(PupilServiceOld pupilService) {
        this.pupilService = pupilService;
    }

    @GetMapping("/")
    public ResponseEntity<?> hi() {
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Hello World!");
        HelloWorld helloWorld = new HelloWorld("Hello from pupils!");
        return ResponseEntity.ok(helloWorld);
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

    @DeleteMapping("/del")
    public ResponseEntity<?> delPupil(@RequestParam("idSchool") int idSchool, @RequestParam("idPupil") int idPupil) {
        try {
            return ResponseEntity.ok(pupilService.delPupil(idSchool, idPupil));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPupil(@RequestParam("idSchool") int idSchool, @RequestBody Pupil pupil) {
        try {
            List<Pupil> newList = pupilService.postPupil(idSchool, pupil);
            return ResponseEntity.ok(pupilService.getPupils(idSchool));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
    }

    @PutMapping ("/edit")
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
