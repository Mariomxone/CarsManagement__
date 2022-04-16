package Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("auth")

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
    })
    Call<User> loginUser(@Body User user);



    @GET("carros/{id}")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
    })
    Call<Carro> getUser (@Path("id") int id);
}
