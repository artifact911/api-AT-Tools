package org.art.dto.pupil;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
//@Schema(name = "dto_patch_pupil_req_body", description = "PatchPupilReqBody DTO", implementation = PatchPupilReqBody.class)
public class PatchPupilReqBody {

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "Саша")
    private String firstName;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "Грей")
    private String lastName;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "FEMALE")
    private String gender;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private int clazz;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "C")
    private String postfix;
}
