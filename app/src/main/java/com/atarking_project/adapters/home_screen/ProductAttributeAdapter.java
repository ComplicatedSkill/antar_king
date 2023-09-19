package com.atarking_project.adapters.home_screen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atarking_project.R;
import com.atarking_project.models.ProductAttributes;

import java.util.List;

public class ProductAttributeAdapter extends RecyclerView.Adapter<ProductAttributeAdapter.ProductVariationViewHolder> {
    private List<ProductAttributes> productAttributesList;
    private Context context;

    public ProductAttributeAdapter(List<ProductAttributes> productAttributesList, Context context) {
        this.productAttributesList = productAttributesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductVariationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_size,parent,false);
        return new ProductVariationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVariationViewHolder holder, int position) {
        ProductAttributes productAttributes = productAttributesList.get(position);
        if (productAttributes != null){
            holder.productSize.setText(productAttributes.getOption());
        }
    }

    @Override
    public int getItemCount() {
        return productAttributesList.size();
    }


    public static class ProductVariationViewHolder extends RecyclerView.ViewHolder {
        TextView productSize;
        public ProductVariationViewHolder(@NonNull View itemView) {
            super(itemView);
            productSize = itemView.findViewById(R.id.productSize);
        }
    }
}
