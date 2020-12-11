package com.example.lession07_restapi.responses;

import com.example.lession07_restapi.models.Product;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsResponse extends BaseResponse {
    @SerializedName("data")
    public List<Product> products;
}
