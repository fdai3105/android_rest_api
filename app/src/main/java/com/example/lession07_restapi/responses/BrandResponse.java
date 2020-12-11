package com.example.lession07_restapi.responses;

import com.example.lession07_restapi.models.Brand;
import com.google.gson.annotations.SerializedName;

public class BrandResponse extends BaseResponse {
    @SerializedName("data")
    public Brand brand;
}
