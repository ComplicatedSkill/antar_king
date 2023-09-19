package com.atarking_project.models.home_response;

import java.util.List;

import com.atarking_project.models.Categories;
import com.atarking_project.models.ProductPopular;
import com.google.gson.annotations.SerializedName;

public class HomResponse{

	@SerializedName("Popular")
	private List<ProductPopular> popular;

	@SerializedName("all_products")
	private List<AllProducts> allProducts;

	@SerializedName("categories")
	private List<Categories> categories;

	@SerializedName("banners")
	private List<Object> banners;

	public void setPopular(List<ProductPopular> popular){
		this.popular = popular;
	}

	public List<ProductPopular> getPopular(){
		return popular;
	}

	public void setAllProducts(List<AllProducts> allProducts){
		this.allProducts = allProducts;
	}

	public List<AllProducts> getAllProducts(){
		return allProducts;
	}

	public void setCategories(List<Categories> categories){
		this.categories = categories;
	}

	public List<Categories> getCategories(){
		return categories;
	}

	public void setBanners(List<Object> banners){
		this.banners = banners;
	}

	public List<Object> getBanners(){
		return banners;
	}

	@Override
 	public String toString(){
		return 
			"HomResponse{" + 
			"popular = '" + popular + '\'' + 
			",all_products = '" + allProducts + '\'' + 
			",categories = '" + categories + '\'' + 
			",banners = '" + banners + '\'' + 
			"}";
		}
}