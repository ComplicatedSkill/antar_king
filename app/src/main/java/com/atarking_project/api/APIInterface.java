package com.atarking_project.api;

import com.atarking_project.models.HomResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/api/get_data_home_page?per_page=10&page=1")
    Call<HomResponse> getProductHomePage();
}
