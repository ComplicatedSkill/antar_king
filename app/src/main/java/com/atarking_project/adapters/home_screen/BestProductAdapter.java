package com.atarking_project.adapters.home_screen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atarking_project.R;
import com.atarking_project.models.ProductPopular;
import com.atarking_project.screens.ScreenProductDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BestProductAdapter extends RecyclerView.Adapter<BestProductAdapter.BastProductViewHolder> {
    private List<ProductPopular> productPopularList;
    private Context context;

    public BestProductAdapter(List<ProductPopular> productPopularList, Context context) {
        this.productPopularList = productPopularList;
        this.context = context;
    }

    @NonNull
    @Override
    public BastProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_view_product_layout,parent,false);
        return new BastProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BastProductViewHolder holder, int position) {
        ProductPopular productPopular = productPopularList.get(position);
        try {
            if (productPopular != null){
                holder.productName.setText(productPopular.getName().toString()+ "...");
                holder.productPrice.setText("$ "+productPopular.getPrice());
                Picasso.with(context).load(productPopular.getImages().get(0).getSrc()).into(holder.image);
            }
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ScreenProductDetailActivity.class);
                    intent.putExtra("PRODUCT_ID", productPopular.getId());
                    context.startActivity(intent);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return productPopularList.size();
    }

    public static class  BastProductViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView productName, productPrice;
        public BastProductViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.productThumbnail);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
        }
    }
}
