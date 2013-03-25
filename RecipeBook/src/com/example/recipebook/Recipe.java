package com.example.recipebook;

import java.io.Serializable;

public class Recipe implements Serializable {
	
	private String id;
	private String name;
	private String minutes;
	private String category;
	private String ingredients;
	private String instructions;
	
	public String getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	
	public String getMinutes(){
		return minutes;
	}
	
	public String getCategory(){
		return category;
	}
	
	public String getIngredients(){
		return ingredients;
	}
	
	public String getInstructions(){
		return instructions;
	}
	
	public void setID(String id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setMinutes(String minutes){
		this.minutes = minutes;
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	public void setIngredients(String ingredients){
		this.ingredients = ingredients;
	}
	
	public void setInstructions(String instructions){
		this.instructions = instructions;
	}
	
	

}
