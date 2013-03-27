package com.example.recipebook.activities;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class RecipeDetailActivity extends SuperActivity{

	private Recipe recipe;
	@Override
	protected void onCreate(Bundle arg0) {
		recipe = (Recipe) getIntent().getExtras().getSerializable("Recipe");
		super.onCreate(arg0);
		
		setContentView(R.layout.activity_detail);
	}
	
	public Recipe getRecipeDetail(){
		return recipe;
	}
	
	public String getCategory(){
		return recipe.getCategory();
	}
}
