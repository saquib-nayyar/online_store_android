package com.example.onlinestore;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RetrofitAPI {

    // as we are making a post request to post a data
    // so we are annotating it with post
    // and along with that we are passing a parameter as users

    @POST("/api/authaccount/login")
    Call<ResponseDataModel> login(@Body DataModal dataModal);


}
