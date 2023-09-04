package com.atarking_project.models;

import com.google.gson.annotations.SerializedName;

public class Categories {

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("slug")
	private String slug;

	@SerializedName("image")
	private Object image;

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

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setImage(Object image){
		this.image = image;
	}

	public Object getImage(){
		return image;
	}

	@Override
 	public String toString(){
		return 
			"CategoriesItem{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",slug = '" + slug + '\'' + 
			",image = '" + image + '\'' + 
			"}";
		}
}