package com.atarking_project.models.home_response;

import java.util.List;

import com.atarking_project.models.Categories;
import com.atarking_project.models.Images;
import com.google.gson.annotations.SerializedName;

public class AllProducts {

	@SerializedName("regular_price")
	private String regularPrice;

	@SerializedName("images")
	private List<Images> images;

	@SerializedName("price")
	private String price;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("categories")
	private List<Categories> categories;

	@SerializedName("sale_price")
	private String salePrice;

	@SerializedName("on_sale")
	private boolean onSale;

	@SerializedName("status")
	private String status;

	public void setRegularPrice(String regularPrice){
		this.regularPrice = regularPrice;
	}

	public String getRegularPrice(){
		return regularPrice;
	}

	public void setImages(List<Images> images){
		this.images = images;
	}

	public List<Images> getImages(){
		return images;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategories(List<Categories> categories){
		this.categories = categories;
	}

	public List<Categories> getCategories(){
		return categories;
	}

	public void setSalePrice(String salePrice){
		this.salePrice = salePrice;
	}

	public String getSalePrice(){
		return salePrice;
	}

	public void setOnSale(boolean onSale){
		this.onSale = onSale;
	}

	public boolean isOnSale(){
		return onSale;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"AllProductsItem{" + 
			"regular_price = '" + regularPrice + '\'' + 
			",images = '" + images + '\'' + 
			",price = '" + price + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",categories = '" + categories + '\'' + 
			",sale_price = '" + salePrice + '\'' + 
			",on_sale = '" + onSale + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}