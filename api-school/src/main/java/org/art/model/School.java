package org.art.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.art.model.schoolstaff.SchoolStaff;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@Schema(name = "school_model", description = "School model", implementation = School.class)
public class School {

    private static int id = 1;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "School Id", example = "1")
    private final int schoolId = id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "City Id", example = "1")
    private int cityId;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "The School name", example = "им. тов.Сухова")
    private String name;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "LessonClass list")
    private List<LessonClass> lessonClassList;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "Teacher list")
    private List<Teacher> teacherList;

    @Schema(accessMode = Schema.AccessMode.READ_WRITE, description = "OtherStaff list")
    private List<SchoolStaff> staffs;

    public School(int cityId, String name, List<LessonClass> lessonClassList,
                  List<Teacher> teacherList, List<SchoolStaff> staffs) {
        this.cityId = cityId;
        this.name = name;
        this.lessonClassList = lessonClassList;
        this.teacherList = teacherList;
        this.staffs = staffs;
        id++;
    }
}
