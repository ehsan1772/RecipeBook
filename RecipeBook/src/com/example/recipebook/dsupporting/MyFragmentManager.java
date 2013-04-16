package com.example.recipebook.dsupporting;

import android.support.v4.app.FragmentActivity;

import com.example.recipebook.Recipe;
import com.example.recipebook.fragments.RecipeDetailFragment;
import com.example.recipebook.fragments.RecipeListFragment;



/**
 * This abstract class has static fields that are used by different classes throughout the application to access the current state of the application.
 * This static fields are used by the activities to get and set data to pass to eachother instead of passing them through instances.
 * it also has abstract methods to start different fragments that get implemented by the concrete subclasses for the tablet and handset version.
 * @author Ehsan Barekati
 *
 */
public abstract class MyFragmentManager {
	
	protected static Recipe recipe;
	protected static String category;
	protected static RecipeListFragment secondFragment;
	protected static RecipeDetailFragment thirdFragment;
	
	
	 public abstract void startCreateNew(FragmentActivity fActivity);
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
		 category = recipe.getCategory();
	 }

}
