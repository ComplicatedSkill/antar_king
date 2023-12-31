package com.atarking_project.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductAttributes {

	@SerializedName("visible")
	private boolean visible;

	@SerializedName("name")
	private String name;

	@SerializedName("options")
	private List<String> options;

	@SerializedName("id")
	private int id;

	@SerializedName("position")
	private int position;

	@SerializedName("variation")
	private boolean variation;

	@SerializedName("option")
	private String option;

	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public boolean isVisible(){
		return visible;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setOptions(List<String> options){
		this.options = options;
	}

	public List<String> getOptions(){
		return options;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public int getPosition(){
		return position;
	}

	public void setVariation(boolean variation){
		this.variation = variation;
	}

	public boolean isVariation(){
		return variation;
	}

	public void setOption(String option){
		this.option = option;
	}

	public String getOption(){
		return option;
	}

	@Override
 	public String toString(){
		return 
			"AttributesItem{" + 
			"visible = '" + visible + '\'' + 
			",name = '" + name + '\'' + 
			",options = '" + options + '\'' + 
			",id = '" + id + '\'' + 
			",position = '" + position + '\'' + 
			",variation = '" + variation + '\'' + 
			",option = '" + option + '\'' + 
			"}";
		}
}