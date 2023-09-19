package com.atarking_project.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atarking_project.R;
import com.atarking_project.adapters.home_screen.ProductAttributeAdapter;
import com.atarking_project.adapters.home_screen.RelatedProductAdapter;
import com.atarking_project.api.APIClient;
import com.atarking_project.api.APIInterface;
import com.atarking_project.models.Images;
import com.atarking_project.models.product_detail.ProductDetail;
import com.atarking_project.models.product_detail.ProductDetailResponse;
import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScreenProductDetailActivity extends AppCompatActivity {

    private LinearLayout cardViewProductImage;
    private TextView  productName, productPrice, testing;
    private HtmlTextView productTitleDescription;
    private APIInterface apiInterface;
    private ImageSlider imageSlider;
    private LinearLayout loadingScreen;
    private Button buttonOpenBottomSheet;
    private RelativeLayout  dataViewScreenDetail;
    private RecyclerView recyclerViewRelatedProduct, recyclerViewProductAttribute;
    private RelatedProductAdapter relatedProductAdapter;
    private ProductAttributeAdapter productAttributeAdapter;
    private ArrayList<SlideModel> slideModels = new ArrayList<>();
    private List<Images> imagesList;

    private ProductDetailResponse productDetailResponse;

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_product_detail);
        Window window = this.getWindow();
        window.setStatusBarColor(Color.BLACK);
        initView();
        getData();
        openBottomSheetCart();
    }

    private void initView(){
        cardViewProductImage = findViewById(R.id.cardViewProductImage);
        productTitleDescription = findViewById(R.id.productTitleDescription);
        imageSlider = findViewById(R.id.productImageSlide);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        loadingScreen = findViewById(R.id.loadingScreen);
        dataViewScreenDetail = findViewById(R.id.dataViewScreenDetail);
        testing = findViewById(R.id.testing);
        recyclerViewRelatedProduct = findViewById(R.id.recyclerViewRelatedProduct);
        buttonOpenBottomSheet = findViewById(R.id.buttonOpenBottomSheet);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        dataViewScreenDetail.setVisibility(View.INVISIBLE);
        loadingScreen.setVisibility(View.VISIBLE);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        ViewGroup.LayoutParams params = cardViewProductImage.getLayoutParams();
        params.height = height/3;


    }


    public void getData(){
        Intent intent = getIntent();
       id = intent.getIntExtra("PRODUCT_ID",0);
        apiInterface.getProductById(id).enqueue(new Callback<ProductDetailResponse>() {
            @Override
            public void onResponse(Call<ProductDetailResponse> call, Response<ProductDetailResponse> response) {
               try {
                   dataViewScreenDetail.setVisibility(View.VISIBLE);
                   loadingScreen.setVisibility(View.GONE);
                   if (response.isSuccessful()){
                       if (response.body().getProductDetail() != null){
                           productDetailResponse = response.body();
                           productTitleDescription.setHtml(response.body().getProductDetail().getDescription(), new HtmlHttpImageGetter(productTitleDescription));
                            productName.setText(response.body().getProductDetail().getName());
                            productPrice.setText("$ "+response.body().getProductDetail().getPrice());

                            imagesList = response.body().getProductDetail().getImages();
                            for (int i = 0; i < imagesList.size(); i++){
                                slideModels.add(new SlideModel(response.body().getProductDetail().getImages().get(i).getSrc(), ScaleTypes.FIT));
                                imageSlider.setImageList(slideModels, ScaleTypes.FIT);
                            }

                       }
                       if (response.body().getRelatedProducts() != null){
                           relatedProductAdapter = new RelatedProductAdapter(response.body().getRelatedProducts(), ScreenProductDetailActivity.this);
                           GridLayoutManager gridLayoutManagerAllProduct = new GridLayoutManager(ScreenProductDetailActivity.this, 2,GridLayoutManager.HORIZONTAL,false);
                           recyclerViewRelatedProduct.setLayoutManager(gridLayoutManagerAllProduct);
                           recyclerViewRelatedProduct.setAdapter(relatedProductAdapter);
                       }

                   }
                   Toast.makeText(getApplicationContext(),"Size => "+ productDetailResponse.getProductDetail().getAttributes(),Toast.LENGTH_SHORT).show();
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

    public void openBottomSheetCart(){
        buttonOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_layout);

       ImageView productImage = dialog.findViewById(R.id.productImage);
       TextView regularPrice = dialog.findViewById(R.id.regular_price);
       TextView salePrice = dialog.findViewById(R.id.salePrice);

       recyclerViewProductAttribute = dialog.findViewById(R.id.recyclerViewProductSize);

        if (productDetailResponse != null){
            Glide.with(ScreenProductDetailActivity.this).load(productDetailResponse.getProductDetail().getImages().get(0).getSrc()).into(productImage);
            if (productDetailResponse.getPriceRange() != null){
                regularPrice.setText("$ "+ productDetailResponse.getPriceRange().getFromPrice());
                salePrice.setText("$ "+ productDetailResponse.getPriceRange().getToPrice());
            }else {
                regularPrice.setText("$ "+productDetailResponse.getProductDetail().getPrice());
                salePrice.setVisibility(View.GONE);
            }

        }

        if (productDetailResponse != null){
            productAttributeAdapter= new ProductAttributeAdapter(productDetailResponse.getProductDetail().getAttributes(), ScreenProductDetailActivity.this);
            GridLayoutManager gridLayoutManagerProductAttribute = new GridLayoutManager(ScreenProductDetailActivity.this, 4,RecyclerView.VERTICAL,false){
                @Override
                public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                    return true;
                }

                @Override
                public boolean canScrollVertically() {
                    return false;
                }

            };
            recyclerViewProductAttribute.setHasFixedSize(true);
            recyclerViewProductAttribute.setLayoutManager(gridLayoutManagerProductAttribute);
            recyclerViewProductAttribute.setAdapter(productAttributeAdapter);
        }

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    public void backProductDetailActivity(View view){
        finish();
    }





}