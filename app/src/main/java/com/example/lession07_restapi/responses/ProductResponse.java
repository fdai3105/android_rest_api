package com.example.lession07_restapi.responses;

import com.example.lession07_restapi.models.Product;
import com.google.gson.annotations.SerializedName;

public class ProductResponse extends BaseResponse {
    @SerializedName("data")
    public Product product;
}


