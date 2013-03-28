package com.example.recipebook.dsupporting;

import android.support.v4.app.FragmentActivity;

import com.example.recipebook.Recipe;
import com.example.recipebook.fragments.RecipeDetailFragment;
import com.example.recipebook.fragments.RecipeListFragment;




public abstract class MyFragmentManager {
	
	protected static Recipe recipe;
	protected static String category;
	protected static RecipeListFragment secondFragment;
	protected static RecipeDetailFragment thirdFragment;
	
	
	 public abstract void startCreateNew();
	 public abstract void startRecipeDetail(FragmentActivity fActivity);
	 public abstract void startRecipeList(FragmentActivity fActivity);
	 public abstract void startCategoryList(FragmentActivity fActivity);
	 
	 public static String getCategory(){
		 return category;
	 }
	 public static void setCategory(String theCategory){
		 category = theCategory;
	 }
	 
	 public static Recipe getRecipe(){
		 return recipe;
	 }
	 public static void setRecipe(Recipe theRecipe){
		 recipe = theRecipe;
	 }

}
