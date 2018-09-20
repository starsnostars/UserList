package services;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderRestClient {
    @GET("users")
    Call<ArrayList<String>> listUsers();
}
