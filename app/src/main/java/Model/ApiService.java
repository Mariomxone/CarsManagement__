package Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @POST("auth")

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
    })
    Call<User> loginUser(@Body User user);
}
