package org.art.services.lessonclass;

import okhttp3.ResponseBody;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;
import retrofit2.Call;
import retrofit2.http.GET;

@Service(type = ServiceType.LOCALHOST, path = "classes/")
public interface LessonClassApiService {

    @GET("all")
    Call<ResponseBody> getAllClasses();
}
