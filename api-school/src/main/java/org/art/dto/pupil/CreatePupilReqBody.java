package org.art.dto.pupil;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
//@Schema(name = "dto_create_pupil_req_body", description = "CreatePupilReqBody DTO", implementation = CreatePupilReqBody.class)
public class CreatePupilReqBody {

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer lessonClassId;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "Саша")
    private String firstName;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "Грей")
    private String lastName;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "FEMALE")
    private String gender;
}
