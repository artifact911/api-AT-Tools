package org.art.services.school;

import okhttp3.ResponseBody;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Service(type = ServiceType.LOCALHOST, path = "schools/")
public interface SchoolApiService {

    String GET_ALL_SCHOOLS_EP = "all";
    String GET_SCHOOL_BY_ID_EP = "id/{schoolId}";

    @GET(GET_ALL_SCHOOLS_EP)
    Call<ResponseBody> getAllSchools();

    @GET(GET_SCHOOL_BY_ID_EP)
    Call<ResponseBody> getSchoolById(@Path("schoolId") int schoolId);
}
