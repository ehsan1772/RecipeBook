package com.example.recipebook.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.activities.RecipeDetailActivity;
import com.example.recipebook.activities.RecipeListActivity;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.listviews.MyAlterDialogue;
import com.example.recipebook.listviews.MyAlterDialogueOwner;

public class RecipeDetailFragment extends Fragment implements MyAlterDialogueOwner{

	private View root;
	private Recipe recipe;
	private TextView recipeName;
	private TextView recipeTime;
	private TextView recipeCategory;
	private TextView recipeIngredients;
	private TextView recipeInstruction;
	private RunQuery runQuery;
	private MyAlterDialogue alterDialogue;
	
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
		 setHasOptionsMenu(true);
		 
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
	

	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
	    inflater.inflate(R.menu.recipe_detai_additional, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.delete:		
			alterDialogue = new MyAlterDialogue(getActivity(), this);
			alterDialogue.show();
			return true;
	    default:
	        return super.onOptionsItemSelected(item);
	}
	}


	public void onYesClicked(int position) {
		runQuery = new RunQuery(DatabaseTask.DELETE_RECIPE);
		runQuery.execute(recipe.getID());
		Intent intent = new Intent(getActivity(), RecipeListActivity.class);
		intent.putExtra("Category", recipe.getCategory());
		startActivity(intent);
		
	}


	public void onNoClicked(int position) {
		// TODO Auto-generated method stub
		
	}
}
