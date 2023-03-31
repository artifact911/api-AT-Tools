package org.art.controller;

import org.art.common.Api;
import org.art.dto.PupilReqBody;
import org.art.helpers.response.RespEntityHelper;
import org.art.model.Pupil;
import org.art.services.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/id/delete/{pupilId}")
    public ResponseEntity<?> delPupilById(@PathVariable("pupilId") Integer id) {
        if (pupilService.delPupilById(id)) {
            return RespEntityHelper.getSuccessResp(HttpStatus.OK);
        }
        return RespEntityHelper.getErrorResp(HttpMethod.DELETE, Api.PUPIL_API, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/id/add/{schoolId}")
    public ResponseEntity<?> addPupilToSchool(@PathVariable Integer schoolId,
                                              @RequestBody PupilReqBody pupilReqBody) {
        if (pupilService.addPupilToSchool(schoolId, pupilReqBody)) {
            return RespEntityHelper.getSuccessResp(HttpStatus.OK);
        }
        return RespEntityHelper.getErrorResp(HttpMethod.POST, Api.PUPIL_API, HttpStatus.INTERNAL_SERVER_ERROR);
    }

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
