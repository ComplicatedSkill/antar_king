package com.atarking_project.adapters.home_screen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.atarking_project.R;
import com.atarking_project.models.product.RelatedProducts;
import com.atarking_project.screens.ScreenProductDetailActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class RelatedProductAdapter extends RecyclerView.Adapter<RelatedProductAdapter.RelatedProductViewHolder> {
    private List<RelatedProducts> relatedProductsList;
    private Context context;

    public RelatedProductAdapter(List<RelatedProducts> relatedProductsList, Context context) {
        this.relatedProductsList = relatedProductsList;
        this.context = context;
    }

    @NonNull
    @Override
    public RelatedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_view_related_product_layout, parent, false);
        return new RelatedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedProductViewHolder holder, int position) {
        RelatedProducts relatedProducts = relatedProductsList.get(position);
        if(relatedProducts != null){
            holder.productName.setText(relatedProducts.getName());
            holder.productPrice.setText("$"+ relatedProducts.getPrice());
            Glide.with(context).load(relatedProducts.getImages().get(0).getSrc()).into(holder.image);
            holder.cardView.setStrokeColor(ContextCompat.getColor(context,R.color.white));
            holder.cardView.setStrokeWidth(2);
        }
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ScreenProductDetailActivity.class);
                intent.putExtra("PRODUCT_ID", relatedProducts.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return relatedProductsList.size();
    }

    public static class RelatedProductViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView productName, productPrice;
        MaterialCardView cardView;
        public RelatedProductViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.productThumbnail);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
