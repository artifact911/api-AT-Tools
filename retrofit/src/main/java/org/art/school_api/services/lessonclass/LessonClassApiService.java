package org.art.school_api.services.lessonclass;

import okhttp3.ResponseBody;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Service(type = ServiceType.LOCALHOST_83, path = "classes/")
public interface LessonClassApiService {

    String GET_ALL_LESSON_CLASSES_EP = "all";
    String GET_CLASS_BY_ID_EP = "id/{classId}";
    String GET_CLASS_BY_LEVEL_EP = "level/{classLevel}";

    @GET(GET_ALL_LESSON_CLASSES_EP)
    Call<ResponseBody> getAllClasses();

    @GET(GET_CLASS_BY_ID_EP)
    Call<ResponseBody> getClassById(@Path("classId") int classId);

    @GET(GET_CLASS_BY_LEVEL_EP)
    Call<ResponseBody> getClassByLevel(@Path("classLevel") int classLevel);
}
