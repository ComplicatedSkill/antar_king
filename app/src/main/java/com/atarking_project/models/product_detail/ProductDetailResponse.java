package com.atarking_project.models.product_detail;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductDetailResponse{

	@SerializedName("product_detail")
	private ProductDetail productDetail;

	@SerializedName("price_range")
	private Object priceRange;

	@SerializedName("product_variations")
	private List<ProductVariationsItem> productVariations;

	@SerializedName("related_products")
	private List<RelatedProductsItem> relatedProducts;

	public void setProductDetail(ProductDetail productDetail){
		this.productDetail = productDetail;
	}

	public ProductDetail getProductDetail(){
		return productDetail;
	}

	public void setPriceRange(Object priceRange){
		this.priceRange = priceRange;
	}

	public Object getPriceRange(){
		return priceRange;
	}

	public void setProductVariations(List<ProductVariationsItem> productVariations){
		this.productVariations = productVariations;
	}

	public List<ProductVariationsItem> getProductVariations(){
		return productVariations;
	}

	public void setRelatedProducts(List<RelatedProductsItem> relatedProducts){
		this.relatedProducts = relatedProducts;
	}

	public List<RelatedProductsItem> getRelatedProducts(){
		return relatedProducts;
	}

	@Override
 	public String toString(){
		return 
			"ProductDetailResponse{" + 
			"product_detail = '" + productDetail + '\'' + 
			",price_range = '" + priceRange + '\'' + 
			",product_variations = '" + productVariations + '\'' + 
			",related_products = '" + relatedProducts + '\'' + 
			"}";
		}
}