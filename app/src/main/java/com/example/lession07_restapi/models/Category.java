package com.example.lession07_restapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("update_at")
    @Expose
    public String updateAt;

}