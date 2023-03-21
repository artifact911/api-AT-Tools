package org.art.services.teacher;

import okhttp3.ResponseBody;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;
import retrofit2.Call;
import retrofit2.http.GET;

@Service(type = ServiceType.LOCALHOST, path = "teachers/")
public interface TeacherApiService {

    @GET("all")
    Call<ResponseBody> getAllTeachers();
}
