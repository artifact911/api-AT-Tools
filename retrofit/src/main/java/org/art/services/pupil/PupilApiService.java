package org.art.services.pupil;

import okhttp3.ResponseBody;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;
import retrofit2.Call;
import retrofit2.http.GET;

@Service(type = ServiceType.LOCALHOST, path = "pupils/")
public interface PupilApiService {

    @GET("all")
    Call<ResponseBody> getAllPupils();
}
