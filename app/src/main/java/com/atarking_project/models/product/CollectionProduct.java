package com.atarking_project.models.product;

import com.google.gson.annotations.SerializedName;

public class CollectionProduct {

	@SerializedName("href")
	private String href;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"CollectionItem{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}