package org.art.services.city;

import okhttp3.ResponseBody;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Service(type = ServiceType.LOCALHOST, path = "cities/")
public interface CityApiService {

    String GET_ALL_CITIES_EP = "all";
    String GET_CITY_BY_ID_EP = "id/{cityId}";

    @GET(GET_ALL_CITIES_EP)
    Call<ResponseBody> getAllCities();

    @GET(GET_CITY_BY_ID_EP)
    Call<ResponseBody> getCityById(@Path("cityId") int cityId);
}
