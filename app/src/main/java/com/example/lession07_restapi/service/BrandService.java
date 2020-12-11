package com.example.lession07_restapi.service;

import com.example.lession07_restapi.responses.BrandResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrandService {
    @GET("brand")
    Call<BrandResponse> getBrand();
}
