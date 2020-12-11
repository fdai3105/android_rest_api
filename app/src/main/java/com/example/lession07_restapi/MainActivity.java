package com.example.lession07_restapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.lession07_restapi.adapters.ProductAdapter;
import com.example.lession07_restapi.responses.ProductsResponse;
import com.example.lession07_restapi.service.ProductService;
import com.example.lession07_restapi.utils.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView main_rv;
    ProductService productService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_rv = findViewById(R.id.main_rv);

        productService = ApiClient.getProductService();
        loadProducts();
    }

    public void loadProducts() {
        productService.getProducts().enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if (response.isSuccessful()) {
                    main_rv.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                    //item change position when fast scroll up
                    main_rv.setItemAnimator(null);
                    ProductAdapter productAdapter = new ProductAdapter(getApplicationContext(), response.body().products, id -> {
                        Intent intent = new Intent(getApplicationContext(), ProductDetail.class);
                        intent.putExtra("productID",id);
                        startActivity(intent);
                    });
                    main_rv.setAdapter(productAdapter);
                } else {
                    Log.e("Code", response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Log.e("onFailure: ", t.toString());
            }
        });
    }
}