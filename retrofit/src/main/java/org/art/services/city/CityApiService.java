package org.art.services.city;

import okhttp3.ResponseBody;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;
import retrofit2.Call;
import retrofit2.http.GET;

@Service(type = ServiceType.LOCALHOST, path = "cities/")
public interface CityApiService {

    @GET("all")
    Call<ResponseBody> getAllCities();
}
