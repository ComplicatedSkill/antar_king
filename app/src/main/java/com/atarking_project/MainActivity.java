package com.atarking_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.atarking_project.adapters.home_screen.AllProductAdapter;
import com.atarking_project.adapters.home_screen.BestProductAdapter;
import com.atarking_project.api.APIClient;
import com.atarking_project.api.APIInterface;
import com.atarking_project.models.home_response.HomResponse;
import com.facebook.shimmer.ShimmerFrameLayout;

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
    private SwipeRefreshLayout swipeRefreshLayout;
    private ShimmerFrameLayout shimmerFrameLayout;
    private LinearLayout linearLayoutDataViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = this.getWindow();
        window.setStatusBarColor(Color.BLACK);
        allProductRecyclerView = findViewById(R.id.recyclerAllProduct);
        bestProductRecyclerView = findViewById(R.id.recyclerViewBestProduct);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayoutHome);
        shimmerFrameLayout = findViewById(R.id.homeScreenPlaceHolder);
        linearLayoutDataViewHome = findViewById(R.id.dataViewHome);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        linearLayoutDataViewHome.setVisibility(View.INVISIBLE);
        shimmerFrameLayout.startShimmer();
        getData();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                getData();
            }
        });

    }

    public void getData(){

        apiInterface.getProductHomePage().enqueue(new Callback<HomResponse>() {
            @Override
            public void onResponse(Call<HomResponse> call, Response<HomResponse> response) {
                linearLayoutDataViewHome.setVisibility(View.VISIBLE);
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.INVISIBLE);
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
                        allProductRecyclerView.setLayoutManager(gridLayoutManagerAllProduct);
                        allProductRecyclerView.setAdapter(allProductAdapter);

                    }
                }

            }

            @Override
            public void onFailure(Call<HomResponse> call, Throwable t) {
                linearLayoutDataViewHome.setVisibility(View.VISIBLE);
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.INVISIBLE);
            }
        });
    }
}