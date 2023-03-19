package com.example.meditation;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import retrofit2.http.POST;

public interface RetrofitAPI {

    @POST("user/login")
    Call<MaskUser> createUser (@Body SendUser sendUser);


}
