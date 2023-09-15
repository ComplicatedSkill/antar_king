package com.atarking_project.models.product_detail;

import java.util.List;

import com.atarking_project.models.Images;
import com.google.gson.annotations.SerializedName;

public class ProductDetail{

	@SerializedName("manage_stock")
	private boolean manageStock;

	@SerializedName("short_description")
	private String shortDescription;

	@SerializedName("images")
	private List<Images> images;

	@SerializedName("stock_status")
	private String stockStatus;

	@SerializedName("price_html")
	private String priceHtml;

	@SerializedName("_links")
	private Links links;

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

	@SerializedName("related_ids")
	private List<Integer> relatedIds;

	@SerializedName("attributes")
	private List<AttributesItem> attributes;

	@SerializedName("id")
	private int id;

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	@SerializedName("sku")
	private String sku;

	@SerializedName("permalink")
	private String permalink;

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

	public void setPriceHtml(String priceHtml){
		this.priceHtml = priceHtml;
	}

	public String getPriceHtml(){
		return priceHtml;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
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

	public void setRelatedIds(List<Integer> relatedIds){
		this.relatedIds = relatedIds;
	}

	public List<Integer> getRelatedIds(){
		return relatedIds;
	}

	public void setAttributes(List<AttributesItem> attributes){
		this.attributes = attributes;
	}

	public List<AttributesItem> getAttributes(){
		return attributes;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategories(List<CategoriesItem> categories){
		this.categories = categories;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	public void setSku(String sku){
		this.sku = sku;
	}

	public String getSku(){
		return sku;
	}

	public void setPermalink(String permalink){
		this.permalink = permalink;
	}

	public String getPermalink(){
		return permalink;
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
			"ProductDetail{" + 
			"manage_stock = '" + manageStock + '\'' + 
			",short_description = '" + shortDescription + '\'' + 
			",images = '" + images + '\'' + 
			",stock_status = '" + stockStatus + '\'' + 
			",price_html = '" + priceHtml + '\'' + 
			",_links = '" + links + '\'' + 
			",description = '" + description + '\'' + 
			",stock_quantity = '" + stockQuantity + '\'' + 
			",sale_price = '" + salePrice + '\'' + 
			",regular_price = '" + regularPrice + '\'' + 
			",price = '" + price + '\'' + 
			",variations = '" + variations + '\'' + 
			",name = '" + name + '\'' + 
			",related_ids = '" + relatedIds + '\'' + 
			",attributes = '" + attributes + '\'' + 
			",id = '" + id + '\'' + 
			",categories = '" + categories + '\'' + 
			",sku = '" + sku + '\'' + 
			",permalink = '" + permalink + '\'' + 
			",on_sale = '" + onSale + '\'' + 
			"}";
		}
}