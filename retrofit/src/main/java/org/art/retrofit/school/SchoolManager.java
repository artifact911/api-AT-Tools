package org.art.retrofit.school;

import lombok.SneakyThrows;
import org.art.RetrofitClientFactory;
import org.art.entity.School;

import java.util.List;

public class SchoolManager {

    SchoolService schoolService = RetrofitClientFactory.initService(SchoolService.class);

    @SneakyThrows
    public List<School> getSchools() {
        return schoolService.getSchools().execute().body();
    }
}
