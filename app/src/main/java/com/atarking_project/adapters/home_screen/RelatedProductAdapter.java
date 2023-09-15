package com.atarking_project.adapters.home_screen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atarking_project.R;
import com.atarking_project.models.product_detail.RelatedProducts;
import com.bumptech.glide.Glide;

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
        View view = LayoutInflater.from(context).inflate(R.layout.cart_view_product_layout, parent, false);
        return new RelatedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedProductViewHolder holder, int position) {
        RelatedProducts relatedProducts = relatedProductsList.get(position);
        if(relatedProducts != null){
            holder.productName.setText(relatedProducts.getName());
            holder.productPrice.setText("$"+ relatedProducts.getPrice());
            Glide.with(context).load(relatedProducts.getImages().get(0).getSrc()).into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return relatedProductsList.size();
    }

    public static class RelatedProductViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView productName, productPrice;
        public RelatedProductViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.productThumbnail);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
        }
    }
}
