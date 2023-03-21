package org.art.services.pupil;

import okhttp3.ResponseBody;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Service(type = ServiceType.LOCALHOST, path = "pupils/")
public interface PupilApiService {

    String GET_ALL_PUPILS_EP = "all";
    String GET_PUPIL_BY_ID_EP = "id/{pupilId}";

    @GET(GET_ALL_PUPILS_EP)
    Call<ResponseBody> getAllPupils();

    @GET(GET_PUPIL_BY_ID_EP)
    Call<ResponseBody> getPupilById(@Path("pupilId") int pupilId);
}
