package org.art.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.art.common.SchoolApi;
import org.art.dto.pupil.PatchPupilReqBody;
import org.art.dto.pupil.CreatePupilReqBody;
import org.art.model.Pupil;
import org.art.services.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.art.helpers.response.RespEntityHelper.getErrorResp;
import static org.art.helpers.response.RespEntityHelper.getSuccessResp;

@Tag(name = "pupil-api", description = "Pupil APIs")
@RestController
@RequestMapping("/pupils")
public class PupilController {

    private final PupilService pupilService;

    @Autowired
    public PupilController(PupilService pupilService) {
        this.pupilService = pupilService;
    }

    // @ExceptionHandler - отловит DAOException и че-то сделает
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Pupil> getAllPupil() {
        return pupilService.getAll();
    }

    // TODO как тут сделать возвращаемый статус код другой, если упало?
    @GetMapping("/id/{pupilId}")
    public ResponseEntity<?> getPupilById(@PathVariable("pupilId") Integer id) {
        try {
            return ResponseEntity.ok(pupilService.getPupilById(id));
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.GET, SchoolApi.PUPIL_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/id/delete/{pupilId}")
    public ResponseEntity<?> delPupilById(@PathVariable("pupilId") Integer id) {
        if (pupilService.delPupilById(id)) {
            return getSuccessResp(HttpStatus.OK);
        }
        return getErrorResp(HttpMethod.DELETE, SchoolApi.PUPIL_API, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/id/add/{schoolId}")
    public ResponseEntity<?> addPupilToSchool(@PathVariable Integer schoolId,
                                              @RequestBody PatchPupilReqBody pupilReqBody) {
        if (pupilService.addPupilToSchool(schoolId, pupilReqBody)) {
            return getSuccessResp(HttpStatus.OK);
        }
        return getErrorResp(HttpMethod.POST, SchoolApi.PUPIL_API, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/create/new")
    public ResponseEntity<?> createNewPupil(@RequestBody CreatePupilReqBody body) {
        try {
            pupilService.createPupil(body);
            return getSuccessResp(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return getErrorResp(HttpMethod.POST, SchoolApi.PUPIL_API, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PatchMapping("id/patch/{pupilId}")
    public ResponseEntity<?> patchPupil(@PathVariable("pupilId") Integer id,
                                        @RequestBody PatchPupilReqBody pupilReqBody) {
        if (pupilService.pathPupil(id, pupilReqBody)) {
            return getSuccessResp(HttpStatus.OK);
        }
        return getErrorResp(HttpMethod.PATCH, SchoolApi.PUPIL_API, HttpStatus.INTERNAL_SERVER_ERROR);
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
