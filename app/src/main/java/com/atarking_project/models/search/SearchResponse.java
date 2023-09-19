package com.atarking_project.models.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SearchResponse{

	@SerializedName("product")
	private List<ProductItem> product;

	public void setProduct(List<ProductItem> product){
		this.product = product;
	}

	public List<ProductItem> getProduct(){
		return product;
	}

	@Override
 	public String toString(){
		return 
			"SearchResponse{" + 
			"product = '" + product + '\'' + 
			"}";
		}
}