package com.atarking_project.models.product;

import java.util.List;

import com.atarking_project.models.Images;
import com.atarking_project.models.ProductAttributes;
import com.google.gson.annotations.SerializedName;

public class ProductVariations {

	@SerializedName("regular_price")
	private String regularPrice;

	@SerializedName("manage_stock")
	private boolean manageStock;

	@SerializedName("image")
	private Images image;

	@SerializedName("stock_status")
	private String stockStatus;

	@SerializedName("price")
	private String price;

	@SerializedName("attributes")
	private List<ProductAttributes> attributes;

	@SerializedName("id")
	private int id;

	@SerializedName("stock_quantity")
	private int stockQuantity;

	@SerializedName("sale_price")
	private String salePrice;

	@SerializedName("on_sale")
	private boolean onSale;

	public void setRegularPrice(String regularPrice){
		this.regularPrice = regularPrice;
	}

	public String getRegularPrice(){
		return regularPrice;
	}

	public void setManageStock(boolean manageStock){
		this.manageStock = manageStock;
	}

	public boolean isManageStock(){
		return manageStock;
	}

	public void setImage(Images image){
		this.image = image;
	}

	public Images getImage(){
		return image;
	}

	public void setStockStatus(String stockStatus){
		this.stockStatus = stockStatus;
	}

	public String getStockStatus(){
		return stockStatus;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setAttributes(List<ProductAttributes> attributes){
		this.attributes = attributes;
	}

	public List<ProductAttributes> getAttributes(){
		return attributes;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStockQuantity(int stockQuantity){
		this.stockQuantity = stockQuantity;
	}

	public int getStockQuantity(){
		return stockQuantity;
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

	@Override
 	public String toString(){
		return 
			"ProductVariationsItem{" + 
			"regular_price = '" + regularPrice + '\'' + 
			",manage_stock = '" + manageStock + '\'' + 
			",image = '" + image + '\'' + 
			",stock_status = '" + stockStatus + '\'' + 
			",price = '" + price + '\'' + 
			",attributes = '" + attributes + '\'' + 
			",id = '" + id + '\'' + 
			",stock_quantity = '" + stockQuantity + '\'' + 
			",sale_price = '" + salePrice + '\'' + 
			",on_sale = '" + onSale + '\'' + 
			"}";
		}
}