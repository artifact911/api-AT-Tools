package org.art.services.school;

import okhttp3.ResponseBody;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;
import retrofit2.Call;
import retrofit2.http.GET;

@Service(type = ServiceType.LOCALHOST, path = "schools/")
public interface SchoolApiService {

    @GET("all")
    Call<ResponseBody> getAllSchools();
}
