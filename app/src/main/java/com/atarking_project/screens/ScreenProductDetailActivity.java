package com.atarking_project.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atarking_project.R;
import com.atarking_project.api.APIClient;
import com.atarking_project.api.APIInterface;
import com.atarking_project.models.product_detail.ProductDetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScreenProductDetailActivity extends AppCompatActivity {

    private LinearLayout cardViewProductImage;
    private TextView productTitleDescription;
    private APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_product_detail);
        initView();
        getData();
    }
    private void initView(){

        Window window = this.getWindow();
        window.setStatusBarColor(Color.BLACK);

        cardViewProductImage = findViewById(R.id.cardViewProductImage);
        productTitleDescription = findViewById(R.id.productTitleDescription);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        ViewGroup.LayoutParams params = cardViewProductImage.getLayoutParams();
        params.height = height/3;

        apiInterface = APIClient.getClient().create(APIInterface.class);

        productTitleDescription.setText("This  watch case and matching bracelet have been specially designed to accommodate the Apple Watch. This high-end accessory enhances the daily use of the Apple Watch. The case is made from high-quality carbon fiber. It therefore offers incredible resistance, guaranteeing your watch’s protection while retaining its sleek design.\n" +
                "\n" +
                "The black strap, meanwhile, is made of vulcanized FKM rubber. It adapts to the  case, providing a solid connection while integrating perfectly. The clasp is made of titanium. It offers a perfect fit to the handles all day long.\n" +
                "\n" +
                "So you can use your Apple Watch to track your physical activity, receive notifications or control your smart home. The  case for Apple Watch is the ideal everyday accessory.\n" +
                "\n" +
                "Adopt the  case today for a better experience with your Apple Watch.\n" +
                "\n" +
                "Features :\n" +
                "\n" +
                "Strap color: Black\n" +
                "Suitable for Apple Watch Series 4 to 8, for all sizes \n" +
                "Carbon fiber case with RAW titanium frame\n" +
                "Easy-to-change FKM rubber strap\n" +
                "Titanium closure\n" +
                "Apple Watch not included");
    }

    public void getData(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("PRODUCT_ID",0);
       apiInterface.getProductById(id).enqueue(new Callback<ProductDetailResponse>() {
           @Override
           public void onResponse(Call<ProductDetailResponse> call, Response<ProductDetailResponse> response) {

           }

           @Override
           public void onFailure(Call<ProductDetailResponse> call, Throwable t) {

           }
       });
    }

    public void backProductDetailActivity(View view){
        finish();
    }

}