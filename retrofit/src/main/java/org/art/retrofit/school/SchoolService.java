package org.art.retrofit.school;

import org.art.entity.School;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import java.util.List;

public interface SchoolService {

    @GET("people/schools")
//    @Headers("Content-Type: application/json")
    Call<List<School>> getSchools();
}
