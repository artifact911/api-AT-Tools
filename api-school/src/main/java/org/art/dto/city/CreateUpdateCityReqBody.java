package org.art.dto.city;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.art.dto.pupil.PatchPupilReqBody;
import org.art.model.School;

import java.util.List;

@Getter
//@Schema(name = "dto_create_update_req_body", description = "CreateUpdateCityReqBody DTO", implementation = CreateUpdateCityReqBody.class)
public class CreateUpdateCityReqBody {

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "Мордор")
    private String name;

    @Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "Мордор")
    private List<School> schools;
}
