package com.example.recipebook.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.activities.RecipeDetailActivity;
import com.example.recipebook.activities.RecipeListActivity;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.listviews.MyRecipeListView;

public class RecipeDetailFragment extends Fragment {

	private View root;
	private Recipe recipe;
	private TextView recipeName;
	private TextView recipeTime;
	private TextView recipeCategory;
	private TextView recipeIngredients;
	private TextView recipeInstruction;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 root = inflater.inflate(R.layout.recipe_detail_view, container, false);
		 
		 recipeName = (TextView) root.findViewById(R.id.recipe_name);
		 recipeTime = (TextView) root.findViewById(R.id.recipe_time);
		 recipeCategory = (TextView) root.findViewById(R.id.recipe_category);
		 recipeIngredients = (TextView) root.findViewById(R.id.recipe_ingredients);
		 recipeInstruction = (TextView) root.findViewById(R.id.recipe_instructions);
		 
		 setRecipes();
		 
		 setContent();
		 
		 return root;
	}
	
	
	private void setRecipes(){

		recipe = ((RecipeDetailActivity) this.getActivity()).getRecipeDetail();
		
	}
	
	private void setContent(){
		 recipeName.setText(recipe.getName());
		 recipeTime.setText(recipe.getMinutes());
		 recipeCategory.setText(recipe.getCategory());
		 recipeIngredients.setText(recipe.getIngredients());
		 recipeInstruction.setText(recipe.getInstructions());
	}
}
