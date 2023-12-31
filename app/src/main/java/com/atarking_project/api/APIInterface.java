package com.atarking_project.api;

import com.atarking_project.models.home_response.HomResponse;
import com.atarking_project.models.product.ProductDetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("/api/get_data_home_page?per_page=10&page=1")
    Call<HomResponse> getProductHomePage();
    @GET("/api/product_detail/{id}")
    Call<ProductDetailResponse> getProductById(@Path("id") Integer id);
    
}
