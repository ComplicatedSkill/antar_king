package com.atarking_project.models.product_detail;

import com.google.gson.annotations.SerializedName;

public class PriceRange{

	@SerializedName("from_price")
	private String fromPrice;

	@SerializedName("to_price")
	private String toPrice;

	public void setFromPrice(String fromPrice){
		this.fromPrice = fromPrice;
	}

	public String getFromPrice(){
		return fromPrice;
	}

	public void setToPrice(String toPrice){
		this.toPrice = toPrice;
	}

	public String getToPrice(){
		return toPrice;
	}

	@Override
 	public String toString(){
		return 
			"PriceRange{" + 
			"from_price = '" + fromPrice + '\'' + 
			",to_price = '" + toPrice + '\'' + 
			"}";
		}
}