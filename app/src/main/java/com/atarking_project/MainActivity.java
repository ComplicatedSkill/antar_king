package com.atarking_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.atarking_project.adapters.home_screen.AllProductAdapter;
import com.atarking_project.adapters.home_screen.BestProductAdapter;
import com.atarking_project.api.APIClient;
import com.atarking_project.api.APIInterface;
import com.atarking_project.models.HomResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView allProductRecyclerView, bestProductRecyclerView;
    private TextView showText;
    private ProgressBar progressBar;
    private APIInterface apiInterface;
    private BestProductAdapter bestProductAdapter;
    private AllProductAdapter allProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = this.getWindow();
        window.setStatusBarColor(Color.BLACK);
        progressBar = findViewById(R.id.progressBar);
        allProductRecyclerView = findViewById(R.id.recyclerAllProduct);
        bestProductRecyclerView = findViewById(R.id.recyclerViewBestProduct);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        progressBar.setVisibility(View.VISIBLE);
        getData();


    }

    public void getData(){

        apiInterface.getProductHomePage().enqueue(new Callback<HomResponse>() {
            @Override
            public void onResponse(Call<HomResponse> call, Response<HomResponse> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()){
                    if (response.body() != null){

                        bestProductAdapter = new BestProductAdapter(response.body().getPopular(), MainActivity.this);
                        GridLayoutManager gridLayoutManagerBestProduct = new GridLayoutManager(MainActivity.this, 1,GridLayoutManager.HORIZONTAL,false);
                        bestProductRecyclerView.setLayoutManager(gridLayoutManagerBestProduct);
                        bestProductRecyclerView.setAdapter(bestProductAdapter);

                        allProductAdapter = new AllProductAdapter(response.body().getAllProducts(), MainActivity.this);
                        GridLayoutManager gridLayoutManagerAllProduct = new GridLayoutManager(MainActivity.this, 2,RecyclerView.VERTICAL,false){
                            @Override
                            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                                return true;
                            }

                            @Override
                            public boolean canScrollVertically() {
                                return false;
                            }

                        };
                        allProductRecyclerView.setHasFixedSize(true);
//                        allProductRecyclerView.setHasFixedSize(true);
                        allProductRecyclerView.setLayoutManager(gridLayoutManagerAllProduct);
                        allProductRecyclerView.setAdapter(allProductAdapter);

                    }
                }

            }

            @Override
            public void onFailure(Call<HomResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}