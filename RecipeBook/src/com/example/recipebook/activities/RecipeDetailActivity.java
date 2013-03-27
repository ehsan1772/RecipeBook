package com.example.recipebook.activities;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class RecipeDetailActivity extends SuperActivity{

	private Recipe recipe;
	private RunQuery runQuery;
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

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		MenuInflater inflater = getMenuInflater();
//	    super.onCreateOptionsMenu(menu);
//	    inflater.inflate(R.menu.recipe_detai_additional, menu);
//	    return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//	switch (item.getItemId()) {
//    case R.id.delete:
//		runQuery = new RunQuery(DatabaseTask.DELETE_RECIPE);
//		runQuery.execute(recipe.getID());
//		Intent intent = new Intent(this, RecipeListActivity.class);
//		intent.putExtra("Category", recipe.getCategory());
//		startActivity(intent);
//    default:
//        return super.onOptionsItemSelected(item);
//	}
//	
//	}
}
