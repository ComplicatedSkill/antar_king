package com.atarking_project.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atarking_project.R;
import com.atarking_project.api.APIClient;
import com.atarking_project.api.APIInterface;
import com.atarking_project.models.Images;
import com.atarking_project.models.product_detail.ProductDetailResponse;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScreenProductDetailActivity extends AppCompatActivity {

    private LinearLayout cardViewProductImage;
    private TextView  productName, productPrice;
    private HtmlTextView productTitleDescription;
    private APIInterface apiInterface;
    private ImageSlider imageSlider;
    private LinearLayout loadingScreen;
    private RelativeLayout  dataViewScreenDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_product_detail);
        Window window = this.getWindow();
        window.setStatusBarColor(Color.BLACK);
        initView();
        getData();
    }

    private void initView(){
        cardViewProductImage = findViewById(R.id.cardViewProductImage);
        productTitleDescription = findViewById(R.id.productTitleDescription);
        imageSlider = findViewById(R.id.productImageSlide);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        loadingScreen = findViewById(R.id.loadingScreen);
        dataViewScreenDetail = findViewById(R.id.dataViewScreenDetail);

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.yellow, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.yellow, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.yellow, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.yellow, ScaleTypes.FIT));

        apiInterface = APIClient.getClient().create(APIInterface.class);

        dataViewScreenDetail.setVisibility(View.INVISIBLE);
        loadingScreen.setVisibility(View.VISIBLE);


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        ViewGroup.LayoutParams params = cardViewProductImage.getLayoutParams();
        params.height = height/3;
    }

    public void getData(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("PRODUCT_ID",0);
        apiInterface.getProductById(id).enqueue(new Callback<ProductDetailResponse>() {
            @Override
            public void onResponse(Call<ProductDetailResponse> call, Response<ProductDetailResponse> response) {

               try {
                   dataViewScreenDetail.setVisibility(View.VISIBLE);
                   loadingScreen.setVisibility(View.GONE);
                   if (response.isSuccessful()){
                       if (response.body().getProductDetail() != null){
                           productTitleDescription.setHtml(response.body().getProductDetail().getDescription(), new HtmlHttpImageGetter(productTitleDescription));

                            productName.setText(response.body().getProductDetail().getName());
                            productPrice.setText("$ "+response.body().getProductDetail().getPrice());
                       }
                   }
               }catch (Exception e){
                   System.out.println(e);
               }
            }

            @Override
            public void onFailure(Call<ProductDetailResponse> call, Throwable t) {
                dataViewScreenDetail.setVisibility(View.VISIBLE);
                loadingScreen.setVisibility(View.GONE);
            }
        });
    }

    public void backProductDetailActivity(View view){
        finish();
    }





}