package org.art.controller;

import org.art.model.Pupil;
import org.art.services.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pupils")
public class PupilController {

    private final PupilService pupilService;

    @Autowired
    public PupilController(PupilService pupilService) {
        this.pupilService = pupilService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Pupil> getAllPupil() {
        return pupilService.getAll();
    }

    @GetMapping("/id/{pupilId}")
    @ResponseStatus(HttpStatus.OK)
    public Pupil getPupilById(@PathVariable("pupilId") Integer id) {
        return pupilService.getPupilById(id);
    }

//    @DeleteMapping("/del")
//    public ResponseEntity<?> delPupil(@RequestParam("idSchool") int idSchool, @RequestParam("idPupil") int idPupil) {
//        try {
//            return ResponseEntity.ok(pupilService.delPupil(idSchool, idPupil));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<?> addPupil(@RequestParam("idSchool") int idSchool, @RequestBody Pupil pupil) {
//        try {
//            List<Pupil> newList = pupilService.postPupil(idSchool, pupil);
//            return ResponseEntity.ok(pupilService.getPupils(idSchool));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
//    }
//
//    @PutMapping ("/edit")
//    public ResponseEntity<?> editPupil(@RequestParam("idSchool") int idSchool, @RequestParam("idPupil") int idPupil,
//                                       @RequestBody Pupil pupil) {
//        try {
//            return ResponseEntity.ok(pupilService.editPupil(idSchool, idPupil, pupil));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
//    }
}
