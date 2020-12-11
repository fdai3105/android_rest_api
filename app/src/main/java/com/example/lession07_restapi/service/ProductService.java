package com.example.lession07_restapi.service;

import com.example.lession07_restapi.models.Product;
import com.example.lession07_restapi.responses.ProductResponse;
import com.example.lession07_restapi.responses.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductService {
    @GET("product")
    Call<ProductsResponse> getProducts();

    @GET("product/{id}")
    Call<ProductResponse> getProduct(@Path("id") long id);

    @POST("product/")
    Call<Void> createProduct(@Body Product product);

    @PUT("product/{id}")
    Call<Void> updateProduct(@Body Product product, @Path("id") int id);

    @DELETE("product/{id}")
    Call<Void> deleteProduct(@Path("id") int id);
}
