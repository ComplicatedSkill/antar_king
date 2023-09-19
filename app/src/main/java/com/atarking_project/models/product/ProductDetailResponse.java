package com.atarking_project.models.product;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductDetailResponse{

	@SerializedName("product_detail")
	private ProductDetail productDetail;

	@SerializedName("price_range")
	private PriceRange priceRange;

	@SerializedName("product_variations")
	private List<ProductVariations> productVariations;

	@SerializedName("related_products")
	private List<RelatedProducts> relatedProducts;

	public void setProductDetail(ProductDetail productDetail){
		this.productDetail = productDetail;
	}

	public ProductDetail getProductDetail(){
		return productDetail;
	}

	public void setPriceRange(PriceRange priceRange){
		this.priceRange = priceRange;
	}

	public PriceRange getPriceRange(){
		return priceRange;
	}

	public void setProductVariations(List<ProductVariations> productVariations){
		this.productVariations = productVariations;
	}

	public List<ProductVariations> getProductVariations(){
		return productVariations;
	}

	public void setRelatedProducts(List<RelatedProducts> relatedProducts){
		this.relatedProducts = relatedProducts;
	}

	public List<RelatedProducts> getRelatedProducts(){
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