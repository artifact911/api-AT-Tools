package org.art.services.teacher;

import okhttp3.ResponseBody;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import java.util.Map;

@Service(type = ServiceType.LOCALHOST, path = "teachers/")
public interface TeacherApiService {

    String GET_ALL_TEACHERS_EP = "all";
    String GET_TEACHER_BY_ID_EP = "id/{teacherId}";
    String GET_CLASS_BY_TECHNOLOGY_EP = "technology";
    String GET_TICKET_PATH = "{ticketPath}";

    @GET(GET_ALL_TEACHERS_EP)
    Call<ResponseBody> getAllTeachers();

    @GET(GET_TEACHER_BY_ID_EP)
    Call<ResponseBody> getTeacherById(@Path("teacherId") int teacherId);

    @GET(GET_CLASS_BY_TECHNOLOGY_EP)
    Call<ResponseBody> getTeachersByTechnology(@QueryMap Map<String, String> params);

    @GET(GET_TICKET_PATH)
    Call<ResponseBody> getTicket(@Path("ticket") String ticketPath);
}
