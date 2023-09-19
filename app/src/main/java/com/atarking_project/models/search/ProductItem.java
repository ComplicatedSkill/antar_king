package com.atarking_project.models.search;

import java.util.List;
import java.util.jar.Attributes;

import com.atarking_project.models.Categories;
import com.atarking_project.models.Images;
import com.google.gson.annotations.SerializedName;

public class ProductItem{

	@SerializedName("manage_stock")
	private boolean manageStock;

	@SerializedName("short_description")
	private String shortDescription;

	@SerializedName("images")
	private List<Images> images;

	@SerializedName("stock_status")
	private String stockStatus;

	@SerializedName("description")
	private String description;

	@SerializedName("stock_quantity")
	private Object stockQuantity;

	@SerializedName("sale_price")
	private String salePrice;

	@SerializedName("regular_price")
	private String regularPrice;

	@SerializedName("price")
	private String price;

	@SerializedName("variations")
	private List<Integer> variations;

	@SerializedName("name")
	private String name;

	@SerializedName("attributes")
	private List<Attributes> attributes;

	@SerializedName("id")
	private int id;

	@SerializedName("categories")
	private List<Categories> categories;

	@SerializedName("sku")
	private String sku;

	@SerializedName("on_sale")
	private boolean onSale;

	public void setManageStock(boolean manageStock){
		this.manageStock = manageStock;
	}

	public boolean isManageStock(){
		return manageStock;
	}

	public void setShortDescription(String shortDescription){
		this.shortDescription = shortDescription;
	}

	public String getShortDescription(){
		return shortDescription;
	}

	public void setImages(List<Images> images){
		this.images = images;
	}

	public List<Images> getImages(){
		return images;
	}

	public void setStockStatus(String stockStatus){
		this.stockStatus = stockStatus;
	}

	public String getStockStatus(){
		return stockStatus;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setStockQuantity(Object stockQuantity){
		this.stockQuantity = stockQuantity;
	}

	public Object getStockQuantity(){
		return stockQuantity;
	}

	public void setSalePrice(String salePrice){
		this.salePrice = salePrice;
	}

	public String getSalePrice(){
		return salePrice;
	}

	public void setRegularPrice(String regularPrice){
		this.regularPrice = regularPrice;
	}

	public String getRegularPrice(){
		return regularPrice;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setVariations(List<Integer> variations){
		this.variations = variations;
	}

	public List<Integer> getVariations(){
		return variations;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAttributes(List<Attributes> attributes){
		this.attributes = attributes;
	}

	public List<Attributes> getAttributes(){
		return attributes;
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

	public void setSku(String sku){
		this.sku = sku;
	}

	public String getSku(){
		return sku;
	}

	public void setOnSale(boolean onSale){
		this.onSale = onSale;
	}

	public boolean isOnSale(){
		return onSale;
	}

	@Override
 	public String toString(){
		return 
			"ProductItem{" + 
			"manage_stock = '" + manageStock + '\'' + 
			",short_description = '" + shortDescription + '\'' + 
			",images = '" + images + '\'' + 
			",stock_status = '" + stockStatus + '\'' + 
			",description = '" + description + '\'' + 
			",stock_quantity = '" + stockQuantity + '\'' + 
			",sale_price = '" + salePrice + '\'' + 
			",regular_price = '" + regularPrice + '\'' + 
			",price = '" + price + '\'' + 
			",variations = '" + variations + '\'' + 
			",name = '" + name + '\'' + 
			",attributes = '" + attributes + '\'' + 
			",id = '" + id + '\'' + 
			",categories = '" + categories + '\'' + 
			",sku = '" + sku + '\'' + 
			",on_sale = '" + onSale + '\'' + 
			"}";
		}
}